package com.Elysian.SpringBootExercise.services;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {


    @Bean
    public net.sf.ehcache.CacheManager ehCacheManager() {
        CacheConfiguration newsCache = new CacheConfiguration();
        newsCache.setName("news");
        newsCache.setMemoryStoreEvictionPolicy("LRU");

        newsCache.setMaxEntriesLocalHeap(1000);
        newsCache.setTimeToLiveSeconds(1800);
        

        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(newsCache);
        return net.sf.ehcache.CacheManager.newInstance(config);
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
}