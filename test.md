
## ~待发布版本~（已发布v1.1.1）

待发布版本暂使用 **Jit Pack** 仓库；待收集的一些问题测试稳定后，再统一发布正式版本至 **Maven Central** 仓库。

## 引入

### Gradle:

1. 在Project的 **build.gradle** 或 **setting.gradle** 中添加远程仓库

    ```gradle
    repositories {
        //...
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
    ```

2. 在Module的 **build.gradle** 里面添加引入依赖项

    ```gradle
   implementation 'com.github.jenly1314:ArcSeekBar:17b52aba64'

    ```
