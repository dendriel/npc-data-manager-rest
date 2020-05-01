package com.rozsa.model;

public class Icon {
    private String imageFile;

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
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

        boolean isEqual = imageFile.equals(other.getImageFile());
        return isEqual;
    }
}
