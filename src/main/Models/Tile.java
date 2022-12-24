package main.Models;

import main.Enums.Resource;

import java.util.ArrayList;
import java.util.List;

public class Tile {

    private List<Resource> resourceBenefits;

    public Tile() {
        resourceBenefits = new ArrayList<>();
    }

    public void addResourceBenefit(Resource resource, int count) {
        for (int i = 0; i < count; i++) {
            resourceBenefits.add(resource);
        }
    }

    public List<Resource> getResourceBenefits() {
        return resourceBenefits;
    }
}
