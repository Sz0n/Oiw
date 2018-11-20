package app;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ChampionManager {
    List<Champion> champions = new ArrayList<Champion>();

    public ChampionManager() {
        champions.add(new Champion("Talon", "the Blade's Shadow", "Assassin", "Mid/Top"));
        champions.add(new Champion("Zed", "the Master of Shadows", "Assassin", "Mid"));
        champions.add(new Champion("Darius", "the Hand of Noxus", "Fighter", "Top"));
        champions.add(new Champion("Malzahar", "the Prophet of the Void", "Mage", "Mid"));
        champions.add(new Champion("Brand", "the Burning Vengeance", "Mage", "Support"));
        champions.add(new Champion("Dr. Mundo", "the Madman of Zaun", "Tank", "Jungle/Top"));
        champions.add(new Champion("Rengar", "the Pridestalker", "Assassin", "Jungle"));
        champions.add(new Champion("Lucian", "the Purifier", "Marksman", "Bot"));
        champions.add(new Champion("Draven", "the Glorious", "Marksman", "Bot"));
        champions.add(new Champion("Malphite", "Shard of the Monolith", "Tank", "Top"));
    }

    public List<Champion> getChampions() {
        return champions;
    }

    public Champion getChampion(int id) {
        return champions.get(id);
    }

    public void addChampion(Champion champion) {
        champions.add(champion);
    }

    public void delChampion(int id){
        champions.remove(id);
    }

    public void putChampion(int id, Champion champion) {
        champions.set(id, champion);
    }

}
