package com.rozsa.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatusModifier {
    private int lifeModifier;
    private int manaModifier;
    private int skillModifier;
    private List<PersistentStatusModifier> applyPersistentStatusModifiers;
    private List<PersistentStatusModifier> removePersistentStatusModifiers;

    public StatusModifier() {
        applyPersistentStatusModifiers = new ArrayList<>();
        removePersistentStatusModifiers = new ArrayList<>();
    }
}
