package point.mmh.com.myplugin.voice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guoqj
 * @描述:声音的工厂
 * @Copyright Copyright (c) 2016
 * @Company 昆山妈妈好网络科技有限公司
 * @date 2018/12/28 0028
 */
public class VideoFactory {

    public static VideoBeans getVideoBeans(String msg){
        VideoBeans videoBeans=new VideoBeans();
        videoBeans.setMsg(msg);
        return videoBeans;
    }

  public static List<VideoBeans> getVideoBeans(List<String> strs){
      List<VideoBeans> lists=new ArrayList<>(strs.size());
      for(String  str:strs){
          lists.add(getVideoBeans(str));
      }
      return lists;
  }


}
