# @RequiredArgsConstructor
- final 이나 @NotNull 이 붙은 필드를 인자로 갖는 생성자를 자동 생성한다.
- 생성자 DI를 편하게 해준다.


#Integration Test
-@ExtendWith(SpringExtension.class)
-@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
-@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
-@AutoConfigureMockMvc

#Unit Test
-Class 에 다음 애노테이션 필요 @ExtendWith(SpringExtension.class) @DirtiesContext
-의존성 있는 빈 @MockBean 애노테이션 통해서 모의 빈 생성하여 DI함
