# @RequiredArgsConstructor
- final 이나 @NotNull 이 붙은 필드를 인자로 갖는 생성자를 자동 생성한다.
- 생성자 DI를 편하게 해준다.


# Integration Test
```
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)    // 여러개의 테스트가 있을때 서로 영향을 줄 수 있으므로 사용했음
@AutoConfigureMockMvc
```
# Unit Test
- Class 에 다음 애노테이션 필요
```
@ExtendWith(SpringExtension.class) 
@DirtiesContext
```
- 의존성 있는 빈 @MockBean 애노테이션 통해서 모의 빈 생성하여 DI함

# MockMvc 객체로 모의 http 요청 구현 가능
- Unit 테스트 시
```
  MockMvc mockMvc;
  @BeforeEach
	public void before() {
    mockMvc = MockMvcBuilders.standaloneSetup(equipmentController)
          .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())   // 전달 받은 인자를 통해 Pageable 인터페이스의 인스턴스를 처리할수 있게끔
          .build();
  }
```

- Integration 테스트 시
```
  @Autowired
  MockMvc mockMvc;
```

# 테스트 Configuration 설정 (테스트에 필요한 Bean 생성 및 의존성 주입)
- Test Class 내부에 static config class 생성 
- Sample
```
  @Configuration
	public static class config {
		@Bean
		public ComponentClassName1 beanName(DependantComponentClassName1 dependantComponentBeanName1, ComponentClassName2 beanName2) {
			return new ComponentClassName(dependantComponentBeanName1, beanName2);
		}
		
		@Bean
		public ComponentClassName2 beanName2(DependantComponentClassName1 dependantComponentBeanName1, DependantComponentClassName3 dependantComponentBeanName3) {
			return new ComponentClassName(dependantComponentBeanName1, dependantComponentBeanName3);
		}
	}
  
  @Autowired
  ComponentClassName1 beanName;
  
  @MockBean
  DependantComponentClassName1 dependantComponentBeanName1;
  
  @MockBean
  DependantComponentClassName3 dependantComponentBeanName3
```

# @Test 애노테이션 단 test 메서드 안에서
- MockBean 객체 인자->반환 설정
```
  when(dependantComponentBeanName1.func1(arg1)).thenReturn(rtn);
```
- HTTP Request 테스트
```
  MvcResult result = mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk()).andReturn();  // http request 날리고 기대값 검사, 반환값 저장
  String jsonString = result.getResponse().getContentAsString();                  // 반환값 String 추출
  VoClassName vo =  new ObjectMapper().readValue(jsonString, VoClassName.class);  // 반환값 파싱 / vo 아니여도 됨 그냥 파싱하는 방법의 차이
  assertEquals(기대값, 반환값);                                                    // 테스트
```
