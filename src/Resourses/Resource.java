package Resourses;

public class Resource {
    protected String name;
    protected ResourceType resourceType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}

