package com.mdx.lib.hero;

import com.alibaba.excel.read.listener.PageReadListener;
import com.mdx.utils.ExcelUtils;

import java.util.HashMap;
import java.util.Map;

public class HeroRead {

    private static final Map<Integer, HeroInfo> HERO_MAP = new HashMap<>();

    public static void readExcel() {
        ExcelUtils.readExcel("lol-hero.xls", HeroData.class, new PageReadListener<HeroData>(dataList -> {
            for (HeroData heroData : dataList) {
                HeroInfo heroInfo = HeroInfo.from(heroData);
                HERO_MAP.put(heroInfo.getNo(), heroInfo);
            }
        })).sheet().doRead();
    }

    public static Map<Integer, HeroInfo> getHeroMap() {
        return HERO_MAP;
    }

    private HeroRead() {
        throw new UnsupportedOperationException();
    }

}
