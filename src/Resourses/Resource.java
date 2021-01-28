package Resourses;

public class Resource {
    protected String name;
    protected int availableCount;
    protected ResourceType resourceType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public void setAvailableCount(int availableCount) {
        this.availableCount = availableCount;
    }
}

