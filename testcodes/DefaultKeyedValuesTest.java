package org.jfree.data.test; 
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.UnknownKeyException;
import org.junit.*;


public class DefaultKeyedValuesTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    /*getItemCount testing*/
    @Test
            (expected = NullPointerException.class)
    public void getItemCount_nullObject_expectedNullPointerException(){
        DefaultKeyedValues defaultKeyedValues = null;
        defaultKeyedValues.getItemCount();
    }

    /*getItemCount testing*/
    @Test
    public void getItemCount_zeroItemAdded_expectedZero(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        Assert.assertEquals(0,defaultKeyedValues.getItemCount(),0);
    }

    /*getItemCount testing*/
    @Test
            (expected = IllegalArgumentException.class)
    public void getItemCount_nullItemAdded_expectedIllegalArgument(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue(null,10);
        defaultKeyedValues.getItemCount();
 
       
    }

    /*getItemCount testing*/    
    @Test
    public void getItemCount_addSameString_expectedTrueValue(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue(" ",1);
        defaultKeyedValues.addValue(" ",2);
        Assert.assertEquals(1,defaultKeyedValues.getItemCount(),0);
    }

    /*getItemCount testing*/    
    @Test
    public void getItemCount_oneString_expectedTrueValue(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("123",1);
        Assert.assertEquals(1,defaultKeyedValues.getItemCount(),0);
    }



    /*getKey testing*/
    @Test
    public void getKey_validKey_expectedTrue(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("samsunspor",1);
        defaultKeyedValues.addValue("55",1);
        Assert.assertEquals("55",defaultKeyedValues.getKey(1));
    }

    /*getKey testing*/
    @Test
            (expected = IndexOutOfBoundsException.class)
    public void getKey_invalidKey_expectedOutofBound(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("samsun",1);
        defaultKeyedValues.addValue("spor",3);
        defaultKeyedValues.getKey(5);
    }


    /*getIndex testing*/

    @Test
    public void getIndex_validString_expectedTrueIndex(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("artvin",1);
        defaultKeyedValues.addValue("hopa",3);
        Assert.assertEquals(0,defaultKeyedValues.getIndex("artvin"),0);
    }

    
    /*getIndex testing*/
    @Test
    public void getIndex_invalidString_expectedMINUSONE(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("sergen",1);
        defaultKeyedValues.addValue("1511",3);
        Assert.assertEquals(-1,defaultKeyedValues.getIndex("topcu"),0);
    }


    /*getKeys testing*/
    @Test
    public void getKeys_EmptyValue_expectedEmptyList(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        Assert.assertEquals(0,defaultKeyedValues.getKeys().size(),0);

    }

    
    /*getKeys testing*/
    @Test
    public void getKeys_twoValue_expectedList(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("yekta",1);
        defaultKeyedValues.addValue("ozer",3);
        Assert.assertEquals("yekta",defaultKeyedValues.getKeys().get(0));
        Assert.assertEquals("ozer",defaultKeyedValues.getKeys().get(1));
    }


    /*getValue testing*/

    @Test
    public void getValue_addNullValue_expectedRetunsNull(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("dafda",1);
        defaultKeyedValues.addValue("444",3);
        defaultKeyedValues.addValue("444",null);
        Assert.assertEquals(null,defaultKeyedValues.getValue("444"));
    }

    /*getValue testing*/
    @Test
            (expected = UnknownKeyException.class)
    public void getValue_invalidKey_expectedUnknownKeyException(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("fvd",1);
        defaultKeyedValues.addValue("sfa",3);
        defaultKeyedValues.getValue("fad");
    }

    
    /*getValue testing*/
    @Test
    public void getValue_validKey_exceptedTrueValue(){
        DefaultKeyedValues defaultKeyedValues = new DefaultKeyedValues();
        defaultKeyedValues.addValue("dfa",1);
        defaultKeyedValues.addValue("654",3);
        Assert.assertEquals(3,defaultKeyedValues.getValue("654").doubleValue(),0);
    }
}
