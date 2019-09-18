package com.cdq.teacher.serviceImpl;

import com.cdq.teacher.global.CreateId;
import com.cdq.teacher.global.Result;
import com.cdq.teacher.mapper.UserMapper;
import com.cdq.teacher.entity.User;
import com.cdq.teacher.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static String fileName="C:\\Users\\Administrator\\Desktop\\Student.txt";

    @Autowired
    UserMapper userMapper;

    @Override
    public User selectUserInfo(String userId) {
        return userMapper.selectUser(userId);
    }

    /**
     * 通过用户名称查询用户
     * @param userName
     * @return
     */
    @Override
    public User selectUserInfoFile(String userName) {
       try{
           List<User> userList= getOldUserList();
           if(userList==null){
               System.out.println("没有对象");
               return null;
           }else {
               for(int i=0;i<userList.size();i++){
                   if(userName.equals(userList.get(i).getUserName())){
                       return userList.get(i);
                   }
               }
           }
       }catch (Exception e){
           return null;
       }
        return null;
    }

    @Override
    public List<User> getAllUser() {
        try{
            List<User> userList= getOldUserList();
            return userList;
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public boolean inputUserInfoFile(User user) {
       try {
           //获取以往的所有的对象
           List<User> userList=new ArrayList<>();
           if(getOldUserList()!=null){
               userList=getOldUserList();
           }
           user.setUserId(CreateId.genItemId());
           userList.add(user);
           //重新插入文件
           inputFile(userList);
           return true;
       } catch (Exception e){
           return false;
       }
    }

    @Override
    public boolean deleteUserFlie(String UserName) {
        try{
            List<User> userList= getOldUserList();
            if(userList==null){
                System.out.println("没有对象");
                return false;
            }else {
                for(int i=0;i<userList.size();i++){
                    if(UserName.equals(userList.get(i).getUserName())){
                        userList.remove(userList.get(i));
                        inputFile(userList);
                        return true;
                    }
                }
            }
        }catch (Exception e){
            return false;
        }
       return false;
    }

    @Override
    public boolean modifyUserFlie(User user) {
        List<User> userList= getOldUserList();
        String UserName=user.getUserName();
        if(userList==null){
            System.out.println("没有对象");
            return false;
        }else {
            for(int i=0;i<userList.size();i++){
                if(UserName.equals(userList.get(i).getUserName())){
                    //修改密码
                    userList.get(i).setPassWord(user.getPassWord());
                    inputFile(userList);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取原来文件对象
     * @return
     */
    public static List<User> getOldUserList(){
        List<User> userList=null;
        try {
            ObjectInputStream input= new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            if(input!=null)
            {
                System.out.println("文件不为空");
                userList=(ArrayList<User>)input.readObject();
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("读取失败");
        } catch (ClassNotFoundException e) {
            System.out.println("读取失败");
            e.printStackTrace();
        }
        return userList;
    }

    /**
     * 将一个对象放入列表
     * @param user
     * @return
     */
    public static List<User>  inputUserList(User user){
        //获取原来文件对象
        List<User> lists = new ArrayList<User>();
        lists=getOldUserList();
        //插入对象
        lists.add(user);
        return lists;
    }

    /**
     * 将对象放入文件
     * @param userList
     */
    public static void inputFile(List<User> userList){
        try {
            ObjectOutputStream output=null;
            output=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            output.writeObject(userList);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("文件写入完成!");
        }
    }


}
