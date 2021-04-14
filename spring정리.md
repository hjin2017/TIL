@service 서비스 클

@Repository  dao클

@Component 모든 클

@Autowired 변수 

@Qualifier 변수 우선 선택

```html
<bean id="vo" class="memberanno.MemberVO">
<constructor-arg value="spring"/>
<constructor-arg value="work"/>
</bean>

<bean id="vo2" class="memberanno.MemberVO">
<constructor-arg value="servlet"/>
<constructor-arg value="jsp"/>
</bean>

<bean id="service" class="memberanno.MemberServiceImpl">
<property name="memberDAO" ref="dao"></property>
</bean> -->
```



@Controller

@RequestMapping

@RequestParam

