import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    private  int delimitNum=12;
    public static void main(String[] args){
        //這些都加入 execute()內
        Test test=new Test();
        List<String>  list=test.generateList();
        List<String>  showSpecifiedList= test.showSpecifiedIndex(list);

        // del index=1 and index=11
        for (int i=0;i<list.size();i++) {
            if(test.checkIfMod7Equal1And6(i,list)){
                list.remove(list.get(i));
            }
        }
        System.out.println(list);
        System.out.println(showSpecifiedList);
        System.out.println(test.group(list));
    }
    public List<String> generateList(){
        int num =0;
        List<String> originList= new ArrayList<>();
        for(int i=0;i<36;i++) {
            originList.add(""+num++);
            if(num==delimitNum) {
                num=0;
            }
        }
        return originList;
    }

    public List<String> showSpecifiedIndex(List<String> list){
        int wantedIndex=delimitNum-1;
        List<String> wantedNum=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(Integer.valueOf(list.get(i))%delimitNum==wantedIndex){
                wantedNum.add(list.get(i));
            }
        }

        return  wantedNum;
    }

    public boolean checkIfMod7Equal1And6(int index,List<String> list){
        if(Integer.valueOf(list.get(index))%delimitNum==1 ||
                Integer.valueOf(list.get(index))%delimitNum==(delimitNum-1))
            return true;
        else return  false;
    }

    public List<List<String>> group(List<String> list){
        List<List<String>> group=new ArrayList<>();
        List<String> smList=new ArrayList<>();
        for(int i=0;i<list.size();i++){
            if(smList.isEmpty()){
                smList.add(list.get(i));
//System.out.println(smList);
            }else if(smList.get(0).equals(list.get(i))){
//System.out.println(list.get(i));
                group.add(smList);
//System.out.println(group);
                smList=new ArrayList<>();
                smList.add(list.get(i));
            }else{
                smList.add(list.get(i));
            }
            if(i==(list.size()-1)){
                group.add(smList);
            }
        }
        return group;
    }


}
