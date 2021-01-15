import java.util.ArrayList;
import java.util.List;

public class Lab {
    private int restartIndex =12;

    public List<String > generateList(){

        int num =0;
        List<String> originList= new ArrayList<>();
        for(int i=0;i<36;i++) {
            originList.add(""+num++);
            if(num== restartIndex) {
                num=0;
            }
        }
        return originList;
    }
    public List<String> delSpecifiedIndex(List<String> list){
        List<String> out=list;
        for(int i=0;i<list.size();i++){
            if(getModNumber(i,list) ==1||getModNumber(i,list) ==11){
                list.remove(i);
            }
        }
        return out;
    }
    public int getModNumber(int index,List<String> list){
        return Integer.valueOf(list.get(index))% restartIndex;
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
