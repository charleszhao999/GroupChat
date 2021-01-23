package w2.jan29th.groupchat;

public class Group {
    private String name,creator;
    private int imageId;
    public Group(String name,String creator,int imageId)
    {
        this.name=name;
        this.creator=creator;
        this.imageId=imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getCreator() {
        return creator;
    }

    public String getName() {
        return name;
    }
}
