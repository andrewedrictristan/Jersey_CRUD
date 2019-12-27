import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<Album>();



    public static void main(String[] args) {

        Album album = new Album("88 Rising", "Rich Brian");
        album.addSong("Drive safe", 4.32);
        album.addSong("History", 2.30);
        album.addSong("100 Degrees", 3.30);
        album.addSong("Midsummer Madness", 5.00);
        album.addSong("Japan 88", 2.10);
        album.addSong("Dat $tick", 3.12);
        albums.add(album);

        album = new Album("Meteora", "Linkin Park");
        album.addSong("One more light", 3.30);
        album.addSong("Heavy", 4.10);
        album.addSong("Crawling", 2.10);
        album.addSong("Waiting for the end", 2.30);
        album.addSong("Numb", 4.30);
        album.addSong("Faint",3.20);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Drive safe",playList);
        albums.get(0).addToPlaylist("Midsummer Madness",playList);
        albums.get(0).addToPlaylist("SPEAK",playList); // No title SPEAK
        albums.get(0).addToPlaylist(6,playList);

        albums.get(1).addToPlaylist(1,playList);
        albums.get(1).addToPlaylist(2,playList);
        albums.get(1).addToPlaylist(3,playList);
        albums.get(1).addToPlaylist(4,playList);
        albums.get(1).addToPlaylist(20,playList); // No track 20
        play(playList);



    }


    private static void printMenu(){
        System.out.println("Available actions:\nPress " +
                "0 - To Quit\n" +
                "1 - To play next song\n"+
                "2 - To play previous song\n"+
                "3 - To replay the current song \n"+
                "4 - List the song in the playlist\n"+
                "5 - Print available actions");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("===================================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("===================================");
    }

    private static void play(LinkedList<Song> playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forwards = true;


        ListIterator<Song> li = playList.listIterator();
        if (playList.size() == 0){
            System.out.println("No songs in playlist");
            return;
        }else {
            System.out.println("Now playing: "+ li.next().toString());
        }

        printMenu();
       while (!quit){
           int action = scanner.nextInt();
           scanner.nextLine();

           switch (action){
               case 0:
                   System.out.println("Playlist closed");
                   quit = true;
                   break;
               case 1:
                   if (!forwards){
                       if (li.hasNext()){
                           li.next();
                       }
                       forwards = true;
                       System.out.println("forwards 1a: "+forwards);
                   }
                   if (li.hasNext()){
                       System.out.println("Now playing: "+ li.next().toString());
                   }else {
                       System.out.println("We have reached the end of play !!");
                       forwards = false;
                       System.out.println("forwards 1b: "+forwards);
                   }
                   break;
               case 2:
                   if(forwards){
                       if (li.hasPrevious()){
                           li.previous();
                       }
                       forwards = false;
                       System.out.println("forwards 2a: "+forwards);
                   }
                   if (li.hasPrevious()){
                       System.out.println("Now playing " + li.previous().toString());
                   }else{
                       System.out.println("We are at the start of the playlist !! ");
                       forwards = true;
                       System.out.println("forwards 2b: "+forwards);
                   }
                   break;
               case 3:
                   if(forwards){
                       if (li.hasPrevious()){
                           System.out.println("Now replaying " + li.previous().toString());
                           forwards=false;
                           System.out.println("forwards 3previous: "+forwards);
                       }else {
                           System.out.println("We are at the start of the list.");
                       }
                   }else {
                       if (li.hasNext()){
                           System.out.println("Now replaying " + li.next().toString());
                           forwards= true;
                           System.out.println("forwards 3next: "+forwards);
                       }else {
                           System.out.println("We are at the End of the list.");
                       }
                   }

                    break;
               case 4:
                   printList(playList);
                   break;
               case 5:
                   printMenu();
                   break;
           }
       }
    }
}
