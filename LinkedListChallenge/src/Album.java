import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<Song>();
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songs){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public boolean addSong(String name, double duration){
        if (findSong(name) == null){
            this.songs.add(new Song(name,duration));
            return true;
        }else {
            return false;
        }
    }

    public boolean addToPlaylist(int trackNumber, LinkedList<Song> playList){
        int index = trackNumber -1 ;
        if (index>=0 && index <= this.songs.size()){
            playList.add(songs.get(index));
            return true;
        }else {
            System.out.println("This album doesn't have track: " + trackNumber);
            return false;
        }
    }

    public boolean addToPlaylist(String title, LinkedList<Song> playList){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playList.add(checkedSong);
            return true;
        }else {
            System.out.println("The song " + title + " is not in the album");
            return false;
        }
    }

}
