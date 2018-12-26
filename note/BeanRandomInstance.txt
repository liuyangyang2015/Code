<!-- https://mvnrepository.com/artifact/uk.co.jemos.podam/podam -->
<dependency>
    <groupId>uk.co.jemos.podam</groupId>
    <artifactId>podam</artifactId>
    <version>2.3.5.RELEASE</version>
    <scope>test</scope>
</dependency>
        
 public static void main(String[] args) throws Exception 
 {
   PodamFactory factory = new PodamFactoryImpl();
   ObjectiveScoreParam myPojo = factory.manufacturePojo(ObjectiveScoreParam.class);
   String str = new ObjectMapper().writeValueAsString(myPojo);
   System.out.println(str);
 }
 
 注意：BigDecimal
