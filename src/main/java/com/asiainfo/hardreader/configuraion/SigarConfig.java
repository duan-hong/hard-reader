package com.asiainfo.hardreader.configuraion;

import org.hyperic.jni.ArchNotSupportedException;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarLoader;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.*;

/**
 * @author duanhong
 * @description sigar
 * @date 2019/11/24
 */
@Configuration
public class SigarConfig {
    //静态代码块
    static {
        try {
            initSigar();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //初始化sigar的配置文件
    public static void initSigar() throws IOException {
        SigarLoader loader = new SigarLoader(Sigar.class);
        String lib = null;

        try {
            lib = loader.getLibraryName();
            System.out.println("init sigar so文件====================="+lib);
        } catch (ArchNotSupportedException var7) {
            System.out.println("initSigar() error:{}"+var7.getMessage());
        }
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:/sigar.so/" + lib);
        if (resource.exists()) {
            System.out.println("加载库文件");
            InputStream is = resource.getInputStream();
            File tempDir = new File("/var/log");
            if (!tempDir.exists()){
                tempDir.mkdirs();
            }
            BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(new File(tempDir, lib), false));
            int lentgh = 0;
            while ((lentgh = is.read()) != -1){
                os.write(lentgh);
            }
            is.close();
            os.close();
            System.setProperty("org.hyperic.sigar.path", tempDir.getCanonicalPath());
            // log.info("======================org.hyperic.sigar.path:"+System.getProperty("org.hyperic.sigar.path"));
        }
    }
}
