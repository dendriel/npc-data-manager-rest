package com.rozsa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rozsa.dao.api.Identifiable;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

public class GenericItem implements Identifiable<ObjectId> {
    private String type;

    private ObjectId id;

    private long uid;

    private int level;

    private String name;

    private String description;

    private Sprite spriteData;

    private Icon iconData;

    private int count;

    private int maximumStack;

    private int price;

    // Wearable
    private List<WearableSlotType> wearableSlots;

    private WearableStatus status;

    private WearableAmmoType ammoType;

    private Aim aim;

    private Hit hit;

    // Usable
    private List<StatusModifier> statusModifiersData;

    private String soundEfx;

    public GenericItem(String type) {
        this.type = type;
    }

    public GenericItem() {
        wearableSlots = new ArrayList<>();
        status = new WearableStatus();
        statusModifiersData = new ArrayList<>();
    }

    public Hit getHit() {
        return hit;
    }

    public void setHit(Hit hit) {
        this.hit = hit;
    }

    public Aim getAim() {
        return aim;
    }

    public void setAim(Aim aim) {
        this.aim = aim;
    }

    public WearableAmmoType getAmmoType() {
        return ammoType;
    }

    public void setAmmoType(WearableAmmoType ammoType) {
        this.ammoType = ammoType;
    }

    public List<StatusModifier> getStatusModifiersData() {
        return statusModifiersData;
    }

    public void setStatusModifiersData(List<StatusModifier> statusModifiersData) {
        this.statusModifiersData = statusModifiersData;
    }

    public String getSoundEfx() {
        return soundEfx;
    }

    public void setSoundEfx(String soundEfx) {
        this.soundEfx = soundEfx;
    }

    public List<WearableSlotType> getWearableSlots() {
        return wearableSlots;
    }

    public void setWearableSlots(List<WearableSlotType> wearableSlots) {
        this.wearableSlots = wearableSlots;
    }

    public WearableStatus getStatus() {
        return status;
    }

    public void setStatus(WearableStatus status) {
        this.status = status;
    }

    @JsonIgnore
    @BsonIgnore
    public ObjectId getObjectId() {
        return id;
    }

    @JsonIgnore
    public ObjectId getId() {
        return id;
    }

    @JsonIgnore
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getIdAsText() {
        return id.toString();
    }

    public void setIdAsText(String idAsText) {
        if (idAsText != null && !idAsText.isEmpty()) {
            id = new ObjectId(idAsText);
        }
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMaximumStack() {
        return maximumStack;
    }

    public void setMaximumStack(int maximumStack) {
        this.maximumStack = maximumStack;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Sprite getSpriteData() {
        return spriteData;
    }

    public void setSpriteData(Sprite spriteData) {
        this.spriteData = spriteData;
    }

    public Icon getIconData() {
        return iconData;
    }

    public void setIconData(Icon iconData) {
        this.iconData = iconData;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean typeOf(String targetType) {
        return type.equals(targetType);
    }
}
