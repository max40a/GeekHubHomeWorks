package task2.filetype;

public enum FileType {

    AUDIO("(?i).*\\.(mp3|wav|wm)", "audio.zip"),
    VIDEO("(?i).*\\.(avi|mp4|flv)", "video.zip"),
    IMAGE("(?i).*\\.(jpeg|jpg|gif|tiff|png)", "image.zip");

    private String featurePattern;
    private String nameOfArchive;

    FileType(String featurePattern, String nameOfArchive) {
        this.featurePattern = featurePattern;
        this.nameOfArchive = nameOfArchive;
    }

    public String getFeaturePattern() {
        return featurePattern;
    }

    public String getNameOfArchive() {
        return nameOfArchive;
    }
}