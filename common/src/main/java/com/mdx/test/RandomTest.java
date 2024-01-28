package com.mdx.test;

import com.mdx.lib.hero.HeroInfo;
import com.mdx.lib.hero.HeroRead;
import com.mdx.utils.RandomUtils;
import org.junit.Test;

public class RandomTest {

    @Test
    public void randomHero() {
        HeroRead.readExcel();
        HeroInfo heroInfo = RandomUtils.randomHero();
        System.out.println(heroInfo);
    }

    public static void main(String[] args) {
        HeroRead.readExcel();
        HeroInfo heroInfo = RandomUtils.randomHero();
        System.out.println(heroInfo);
    }

}
