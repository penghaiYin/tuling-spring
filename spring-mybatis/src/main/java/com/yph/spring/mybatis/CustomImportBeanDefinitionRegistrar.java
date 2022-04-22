package com.yph.spring.mybatis;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.util.Map;

public class CustomImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 拿到mapper扫描路径
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(CustomMapperScan.class.getName());
        String path = (String) annotationAttributes.get("value");

        CustomBeanDefinitionScanner scan = new CustomBeanDefinitionScanner(registry);
        // 不加Component，也能扫描到
        scan.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        scan.scan(path);
    }
}
