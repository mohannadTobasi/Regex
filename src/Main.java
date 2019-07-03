import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[]argc){
        File file = new File("regex.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<String> interfaces = new ArrayList<>();
            String inputLine;
            String entry="";
            inputLine = br.readLine();
                if (inputLine==null){
                    System.out.println("file is empty");
                    System.exit(1);
                }
                if(inputLine.length()==0){
                    while(((inputLine = br.readLine()).length()==0));
                }
                entry=inputLine;
                entry+="\n";

            while ((inputLine = br.readLine()) != null) {
                if(inputLine.length()==0){
                    inputLine = br.readLine();
                    if (inputLine==null){
                        break;
                    }
                }
                else if(inputLine.startsWith(" ")){
                    entry += inputLine;
                    entry+="\n";
                }
                else
                {
                interfaces.add(entry);
                entry=inputLine;
                entry+="\n";
                }
            }
            if(entry!=null){
                interfaces.add(entry);
            }
            ArrayList<Interface> arrayList = new ArrayList<>();
            System.out.println("matched interfaces are "+interfaces.size());
            for (String singleInterface:interfaces) {
                Interface inter = new Interface();
                //Interface names
                Pattern pattern = Pattern.compile("^[^\\s]\\w*([^\\s]+)", Pattern.MULTILINE);
                Matcher matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setName(matcher.group(0));
                }
                else
                {
                    inter.setName("");
                }

                //interface ip
                pattern = Pattern.compile("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setIpAddress(matcher.group(0));
                }
                else
                {
                    inter.setIpAddress("");
                }

                //interface Description
                pattern = Pattern.compile("(?<=Description:).*", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setDescription(matcher.group(0));
                }
                else
                {
                    inter.setDescription("");
                }
                //interface speed
                pattern = Pattern.compile("(?<=duplex, ).+(?=,)", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setSpeed(matcher.group(0));

                }
                else
                {
                    inter.setSpeed("");
                }
                //interface duplex
                pattern = Pattern.compile("\\w.*(?<=duplex)", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setDuplex(matcher.group(0));
                }
                else
                {
                    inter.setDuplex("");
                }

                //interface Admin status
                pattern = Pattern.compile("(?<=is )\\w.*(?=,)", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setStatus(matcher.group(0));
                }
                else
                {
                    inter.setStatus("");
                }


                //interface operation status
                pattern = Pattern.compile("(?<=protocol is )\\w.*(?= )", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setOperationStatus(matcher.group(0));
                }
                else
                {
                    inter.setOperationStatus("");
                }

                //interface Mac Address
                pattern = Pattern.compile("(?<=address is ).*?(?= )", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setMacAddress(matcher.group(0));
                }
                else
                {
                    inter.setMacAddress("");
                }

                //interface MTU
                pattern = Pattern.compile("(?<=MTU).*?(?=,)", Pattern.MULTILINE);
                matcher = pattern.matcher(singleInterface);

                if (matcher.find()) {
                    inter.setMtu(matcher.group(0));
                }
                else
                {
                    inter.setMtu("");
                }
                arrayList.add(inter);
            }
        //all done adding the data
            //now printing the data
            for (Interface inter:
                    arrayList ) {
                System.out.println("Interface #"+(arrayList.indexOf(inter)+1)+":");
                System.out.println(inter.toString());
            }



        }
        catch (IOException e){
            System.out.println("File error");
    }
}
}
