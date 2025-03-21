import java.util.*;

class twentyone{
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        HashMap<String,List<String>> hp=new HashMap<>();
        HashMap<String,Integer> indegree=new HashMap<>();

        for(int i=0;i<ingredients.size();i++){
            for(int j=0;j<ingredients.get(i).size();j++){
                hp.putIfAbsent(ingredients.get(i).get(j),new ArrayList<>());
                hp.get(ingredients.get(i).get(j)).add(recipes[i]);
                indegree.put(recipes[i],indegree.getOrDefault(recipes[i],0)+1);
            }
        }

        Queue<String> q=new LinkedList<>();
        for(String s:supplies){
            q.add(s);
        }
        List<String> ans=new ArrayList<>();
        while(!q.isEmpty()){
            String supply=q.poll();

            if(!hp.containsKey(supply)){
                continue;
            }

            for(String rec:hp.get(supply)){
                int ind=indegree.get(rec)-1;
                indegree.put(rec,ind);
                if(ind==0){
                    q.add(rec);
                    ans.add(rec);
                }
            }

        
        }
        return ans;
    }
}