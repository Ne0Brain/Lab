import java.util.ArrayList;
import java.util.List;

public class Lab {
    public List<String > generateList(){

        int num =0;
        List<String> originList= new ArrayList<>();
        for(int i=0;i<36;i++) {
            originList.add(""+num++);
            if(num==12) {
                num=0;
            }
        }
        return originList;
    }
    public List<String> delSpecifiedIndex(List<String> list){
        List<String> out=list;
        for(int i=0;i<list.size();i++){
            if(Integer.valueOf(list.get(i))%12==1||Integer.valueOf(list.get(i))%12==11){
                list.remove(i);
            }
        }
        return out;
    }
    public List<String> checkSpecificNumber(List<String> list){
        List<String> output=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(i==11||i==23||i==35){
                output.add(list.get(i));
            }
        }
        return output;
    }
    public List<List<String>> groupAfterDel(List<String> list){
        List<String> listAfterDel=delSpecifiedIndex(list);
        List<String> smStr=new ArrayList<>();
        List<List<String>> output=new ArrayList<>();
        for(int i=0;i<listAfterDel.size();i++){
            if(listAfterDel.get(0).equals(listAfterDel.get(i))){
                if(!smStr.isEmpty())output.add(smStr);
                smStr=new ArrayList<>();
                smStr.add(listAfterDel.get(i));
            }else{
                smStr.add(listAfterDel.get(i));
            }

        }
        if(smStr.size()!=0){
            output.add(smStr);
        }

        return output;
    }
}
