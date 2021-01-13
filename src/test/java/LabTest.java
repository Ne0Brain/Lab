import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LabTest {
    List<String> originList;
    Lab lab=new Lab();
    @Before
    public void before(){
        int num =0;
        originList= new ArrayList<>();
        for(int i=0;i<36;i++) {
            originList.add(""+num++);
            if(num==12) {
                num=0;
            }
        }

    }

    @Test
    public void whenGenerateListThenReturnOriginList(){
//        Lab lab=new Lab();

        assertEquals(originList,lab.generateList());
    }

    //del index =1 and index=11
    @Test
    public void whenDelThenDeleteIndexOneAndEleven(){
        Lab lab=new Lab();
//        List<String> input=originList;
        originList.remove(String.valueOf(1));
        originList.remove(String.valueOf(11));
        originList.remove(String.valueOf(1));
        originList.remove(String.valueOf(11));
        originList.remove(String.valueOf(1));
        originList.remove(String.valueOf(11));
        assertEquals(originList,lab.delSpecifiedIndex(lab.generateList()));
    }

    @Test
    public void whenCheckThenReturnSpecificIndexValue(){
//        int[] chooseIndex= new int[]{11,23,35};
        List<String> expected=new ArrayList<>();
        expected.add(originList.get(11));
        expected.add(originList.get(23));
        expected.add(originList.get(35));
        assertEquals(expected,lab.checkSpecificNumber(lab.generateList()));
    }
    @Test
    public void whenGroupThenSeperateListWithSameElement(){
        List<List<String>> expected=new ArrayList<>();
        List<String> smStr=new ArrayList<>();
        for(int i=0;i<12;i++){
            if(i==1||i==11){
            }else{
                smStr.add(String.valueOf(i));
            }
        }
        for(int j=0;j<3;j++){
            expected.add(smStr);
        }
        assertEquals(expected,lab.groupAfterDel(lab.generateList()));
    }

}
