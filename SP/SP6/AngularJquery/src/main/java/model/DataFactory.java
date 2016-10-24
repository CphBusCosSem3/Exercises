package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {

  private final List<Member> members = new ArrayList();
  private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

  public DataFactory() {
    Member burch = new Member(29, "brown", "Burch Cherry", "male", "burchcherry@ludak.com");
    members.add(burch);
    Member kelley = new Member(24, "brown", "Kelley Simon", "female", "kelleysimon@viasia.com");
    members.add(kelley);
    Member jami = new Member(30, "blue", "Jami Melendez", "female", "jamimelendez@geekosis.com");
    members.add(jami);
    Member jeanie = new Member(23, "brown", "Jeanie Garrison", "female", "jeaniegarrison@talae.com");
    members.add(jeanie);
    Member richards = new Member(21, "brown", "Richards Chavez", "male", "richardschavez@techtrix.com");
    members.add(richards);
    Member ina = new Member(34, "green", "Ina Gallegos", "female", "inagallegos@egypto.com");
    members.add(ina);
    burch.addFriend(ina);
    burch.addFriend(richards);
    kelley.addFriend(jami);
    kelley.addFriend(jeanie);
    kelley.addFriend(richards);
    jami.addFriend(richards);
    richards.addFriend(ina);
    richards.addFriend(jami);
    ina.addFriend(richards);
  }

  public List<Member> getMembers() {
    return members;
  }
  
  public String getMembersAsJson(){
    JsonArray membersJson = new JsonArray();
    for(Member m: members){
      JsonObject mj = getMemberAsJsonObject(m);
      JsonArray friends = new JsonArray();
      for(Member mf : m.getFriends()){
        friends.add(getMemberAsJsonObject(mf));
      }
      mj.add("friends", friends);
      membersJson.add(mj);
    }
    return gson.toJson(membersJson);
  };

  private JsonObject getMemberAsJsonObject(Member m) {
    JsonObject mj = new JsonObject();
    mj.addProperty("id",m.getId());
    mj.addProperty("age",m.getAge());
    mj.addProperty("eyeColor",m.getEyeColor());
    mj.addProperty("name",m.getName());
    mj.addProperty("email",m.getEmail());
    return mj;
  }
  
  public static void main(String[] args) {
    //Simple test
    DataFactory f = new DataFactory();       
    System.out.println(f.getMembersAsJson());
  }

}
