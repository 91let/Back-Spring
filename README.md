# Back-Spring

## Using STS

## Making Project

![SpringSetting1](/img/SpringSetting1.PNG)

![SpringSetting2](/img/SpringSetting2.PNG)

## How to Cashe

스프링 부트에 캐시를 적용하고 싶으면 3가지만 기억하면 된다.

@EnableCaching, @Cacheable, @CacheEvict

1. "spring-boot-starter-cache" 라이브러리 불러온다.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-cache</artifactId>
</dependency>
```

2. 캐시 기능을 사용하고 싶은 프로젝트에 @EnableCaching을 쓴다.

```
@EnableCaching
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

3. 캐시하고 싶은 메서드에 @Cacheable, 캐시를 제거하고자하는 메서드에는 @CacheEvict를 쓴다.

```
@Service
public class TestService {
    private List<String> list;
    
    @PostConstruct
    public void init() {
        list = new ArrayList<>();
    }
    
    @Cacheable(value="test")
    public String getInformation(String info) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list.stream().filter(x->x.equals(info)).findFirst().get();
    }
    
    @CacheEvict(value="test")
    public void createInformation(String info) {
        list.add(info);
    }
}
```