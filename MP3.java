/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ravi
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.advanced.*;


public class MP3{
    private String filename;
    private AdvancedPlayer player;
    public static Integer count,lastframe;
    /*public void playbackFinished(PlaybackEvent event) {
                
            lastframe = event.getFrame();
            
            }*/
    public MP3(String filename){
        this.filename=filename;
        count=0;
        lastframe=0;
       
        
        
    }
    public void close(){
        if(player!=null)
            player.close();
        count=0;
    }
    public void play(){
        
         try{
            FileInputStream f=new FileInputStream(filename);
            BufferedInputStream b=new BufferedInputStream(f);
            player=new AdvancedPlayer(b);
        }catch(Exception e)
        {}
        //if(count%2==0){
        new Thread(){
            public void run(){
            
                try{
                    player.play(lastframe,Integer.MAX_VALUE);
                }
                catch(Exception e)
                {}
            }
        
        }.start();//}
        /*else
        {
            player.stop();
            player.setPlayBackListener(new PlaybackListener() {
                
            
            });
            try{
            FileInputStream f=new FileInputStream(filename);
            BufferedInputStream b=new BufferedInputStream(f);
            player=new AdvancedPlayer(b);
            }catch(Exception e)
            {
            }
        
        }
        count++;*/
        
    }
}

    
