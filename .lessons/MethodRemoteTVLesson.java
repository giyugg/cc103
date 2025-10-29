import java.util.Scanner;
public class MethodRemoteTVLesson {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int default_Channel = 2;
        int default_Volume = 5;
        int max_Channel = 100;
        int min_Channel = 1;
        int max_Volume = 20;
        int min_Volume = 0;
        
        do {
            int channel= default_Channel;
            int volume = default_Volume;
            System.out.println("POWER ON");
            display(channel, volume);
            menu();
            System.out.println("Choose: ");
            String choice = input.next();
        
            if (choice.equals("+"))
                channel = channelUp(channel, max_Channel);
            else if (choice.equals("-"))
                channel = channelDown(channel, min_Channel);
            else if (choice.equals("++"))
                volume = volumeUp(volume, max_Volume);
            else if (choice.equals("--"))
                volume = volumeDown(volume, min_Volume);
            else if (choice.equals("o")) {
                display(channel, volume);
            System.out.println("POWER OFF");
            System.exit(0);
            }
        } while(true);
    }
    
    public static int volumeDown (int vol, int min_vol) {
        if (vol > min_vol)
            vol--;
        return vol;
    }
    
    public static int volumeUp (int vol, int max_vol) {
        if (vol < max_vol)
            vol++;
        return vol;
    }
    
    public static int channelDown(int ch, int min_ch) {
        if (ch > min_ch)
            ch--;
        return ch;
    }
    
    public static int channelUp(int ch, int max_ch) {
        if (ch<max_ch)
            ch++;
        return ch;
    }
    
    public static void menu() {
        System.out.println("Channel Up:    +");
        System.out.println("Channel Down:  -");
        System.out.println("Volume Up:    ++");
        System.out.println("Volume Down:  --");
        System.out.println("Power Off:     o");
        System.out.println("-------------------");
    }
    
    public static void display(int ch, int vol) {
        System.out.println("-------------------");
        System.out.println("Channel: " + ch);
        System.out.println("Volume: : " + vol);
        System.out.println("-------------------");
    }
}
