package net.bons.comptes.service.model;

import com.google.common.collect.Lists;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class SimpleProject implements Project {
    private String name;
    private String author;
    private String description;
    private String mail;
    private String identifier;
    private int amount;
    private Collection<Contribution> contributions;

    public SimpleProject(JsonObject json) {
        this.name = json.getString("name");
        this.author = json.getString("author");
        this.description = json.getString("description");
        this.mail = json.getString("mail");
        this.identifier = json.getString("identifier");
        this.amount = json.getInteger("amount", 0);
        if (json.containsKey("contributions")) {
            this.contributions = json.getJsonArray("contributions").stream().map(o -> new Contribution((JsonObject) o)).collect(
                    Collectors.toList());
        }
        else {
            this.contributions = Collections.emptyList();
        }
    }

    public SimpleProject() {
    }

    public SimpleProject(SimpleProject project) {
        this.name = project.getName();
        this.author = project.getAuthor();
        this.description = project.getDescription();
        this.mail = project.getMail();
        this.identifier = project.getIdentifier();
        this.amount = project.getAmount();
        this.contributions = project.getContributions();
    }

    public SimpleProject(RawProject project) {
        this.name = project.getName();
        this.author = project.getAuthor();
        this.description = project.getDescription();
        this.mail = project.getMail();
        this.identifier = project.getIdentifier();
        this.amount = project.getAmount();
        this.contributions = project.getContributions().stream()
                                    .map(contribution -> new Contribution(null, contribution.getAuthor(), 0, null, null))
                                    .collect(Collectors.toList());
    }

    SimpleProject(String name, String author, String description, String mail, String identifier, Collection<Contribution> contributions) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.mail = mail;
        this.identifier = identifier;
        this.contributions = contributions;
        this.amount = contributions.stream().collect(Collectors.summingInt(Contribution::getAmount));
    }

    @Override
    public JsonObject toJson() {
        JsonArray jsonDeals = new JsonArray();
        contributions.stream().map(d -> d.toJson()).forEach(jsonDeals::add);
        return new JsonObject()
                .put("name", this.name)
                .put("author", this.author)
                .put("description", this.description)
                .put("mail", this.mail)
                .put("identifier", this.identifier)
                .put("amount", this.amount)
                .put("contributions", jsonDeals);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(SimpleProject project) {
        return new Builder(project);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    public Collection<Contribution> getContributions() {
        return contributions;
    }

    public static class Builder {
        private String name;
        private String author;
        private String description;
        private String mail;
        private String identifier;
        private Collection<Contribution> contributions;

        public Builder() {
            contributions = Collections.emptyList();
        }

        public Builder(SimpleProject project) {
            name = project.getName();
            author = project.getAuthor();
            description = project.getDescription();
            mail = project.getMail();
            identifier = project.getIdentifier();
            contributions = Lists.newArrayList(project.getContributions());
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder mail(String mail) {
            this.mail = mail;
            return this;
        }

        public Builder identifier(String identifier) {
            this.identifier = identifier;
            return this;
        }

        public Builder deals(Collection<Contribution> contributions) {
            this.contributions = contributions;
            return this;
        }

        public Project createRawProject() {
            return new SimpleProject(name, author, description, mail, identifier, contributions);
        }
    }
}
