package com.rozsa.model;

public class Icon {
    private Resource resource;
    private Rect rect;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Rect getRect() {
        return rect;
    }

    public void setRect(Rect rect) {
        this.rect = rect;
    }

    public String getImageFile() {
        return resource != null ? resource.getName() : "";
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        Icon other = (Icon) obj;
        if (other == null) {
            return false;
        }

        boolean isEqual = resource.getStorageId().equals(other.resource.getStorageId());
        isEqual &= rect.equals(other.getRect());
        return isEqual;
    }
}
