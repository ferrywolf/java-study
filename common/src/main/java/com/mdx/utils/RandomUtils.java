package com.mdx.utils;

import com.mdx.lib.hero.HeroInfo;
import com.mdx.lib.hero.HeroRead;

import java.util.Map;
import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static HeroInfo randomHero() {
        Map<Integer, HeroInfo> heroMap = HeroRead.getHeroMap();
        int index = RANDOM.nextInt(heroMap.size());
        return heroMap.get(index);
    }

    private RandomUtils() {
        throw new UnsupportedOperationException();
    }

}
