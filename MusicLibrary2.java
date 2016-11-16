

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import etsy.Track;


public class MusicLibrary2 {
	//music library singleton Instance
	public static MusicLibrary2 musicLibrary=new MusicLibrary2();
	
	//this nested hashmap maps each artist to another map which maps the artist's albums to list of tracks in that album
	static HashMap<String,HashMap<String, List<Track>>> artists=new HashMap<>(); 

	//this HashMap maps the name of each played track to its Track object
	static HashMap<String, Track> tracksPlayed=new HashMap<>(); 
	
	static HashMap<String, Integer> songsRatings=new HashMap<>();
	
	static HashMap<String, Integer> artistRatings=new HashMap<>();

	//private constructor
	private MusicLibrary2(){}
	
	//make it a singleton since we expect only one MusicLibrary at a time to house songs been added to it
	public MusicLibrary2 getInstance(){
		return musicLibrary;
	}
	
	//add Artist to library
	public void addArtist(String artistName){
		artists.put(artistName, new HashMap<String,List<Track>>());
	}
	
	public void addAlbum(String artistName,String albumName){
		if(artists.get(artistName) == null){
			List<Track> tracks=new ArrayList<Track>();
			HashMap<String, List<Track>> albumInfo=new HashMap<>();
			albumInfo.put(albumName, tracks);
			artists.put(artistName,albumInfo);
			return;
		}
		//if artist already exists in the map
		artists.get(artistName).put(albumName,new ArrayList<Track>());
	}
	
	public void addTrack(String artistName,String albumName,String trackName){
		if(artists.get(artistName)==null){
			System.out.println("You must Add an Artist to the Library First");
			return;
		}
		Track newTrack=new Track(trackName,artistName,albumName);
		List<Track> albumTracks=artists.get(artistName).get(albumName);
		albumTracks.add(newTrack);
	}
	
	public void listTracksOnAlbum(String artistName,String albumName)
	{
		if(artists.get(artistName)==null){
			System.out.println("Artist does not exist in library");
			return;
		}
		
		//get the map which maps each album to the list of tracks
		HashMap<String,List<Track>> allAlbumsByArtist=artists.get(artistName);
		
		if(allAlbumsByArtist.get(albumName)==null){
			System.out.println("This Album does not exist in library for "+artistName);
			return;
		}
		//get the list of tracks
		List<Track> listOfTracksInAlbum=allAlbumsByArtist.get(albumName);
		System.out.println("The Tracks for Album: "+albumName +" by "+ artistName+" are:");
		for(int j=0;j<listOfTracksInAlbum.size();j++){
			System.out.println("\t"+listOfTracksInAlbum.get(j).getTrackName());
		}	
	}
	
	public void listenToTrack(String nameOfTrack,String nameOfAlbum,String artistName){
		//check if track exists in music library
		if(!trackExists(nameOfTrack, nameOfAlbum, artistName)){
			System.out.println("Track: "+nameOfTrack+"on: "+nameOfAlbum+" by: "+artistName +"does not exist in Library");
			return;
		}
		//if this song doesn't exist on the songs ratings board, then its added
		if(songsRatings.get(nameOfTrack)==null){
			//place a count of 1 as the first time its being played
			System.out.println("Listening to Track: "+nameOfTrack);
			songsRatings.put(nameOfTrack, 1);
			return;
		}
		//track already exists in the songsRating Map
		System.out.println("Listening to Track: "+nameOfTrack);
		int get_playcount=songsRatings.get(nameOfTrack)+1;
		songsRatings.put(nameOfTrack, get_playcount);
		
		for(Map.Entry<String,Integer> song:songsRatings.entrySet()){
			System.out.println(song.getKey()+":: "+song.getValue());
		}
	}
//	public void listTopTracks(int N){
//		Map<Integer, V>
//	} 
	public boolean trackExists(String trackName,String albumName,String nameOfArtist){
		if(artists.get(nameOfArtist)==null){
			//System.out.println("Artist does not exist in library");
			return false;
		}
		List<Track> tracksByArtist=artists.get(nameOfArtist).get(albumName);
		for(Track track:tracksByArtist){
			if(track.getTrackName().equals(trackName)){
				return true;
			}
		}
		return false;
	}
	
	public void getAlbumsByArtist(String artistName){
		if(artists.get(artistName)==null){
			System.out.println("Artist does not exist in library");
			return;
		}
		
		HashMap<String, List<Track>>allAlbumsByArtist=artists.get(artistName);
		System.out.println("Album List by: "+artistName);
		for(Map.Entry<String, List<Track>> album:allAlbumsByArtist.entrySet()){
			System.out.println(album.getKey());
		}
	} 
	
	public void getAllArtists(){
		if(artists.isEmpty()){
			return;
		}
		System.out.println("All Artists: ");
		for(Map.Entry<String, HashMap<String, List<Track>>> artist:artists.entrySet()){
			System.out.println(artist.getKey());
		}
	}
	
	public void getAllTracks(){
		for(Map.Entry<String,HashMap<String, List<Track>>> artist:artists.entrySet()){
			String artistName=artist.getKey();
			System.out.println(artistName);
			HashMap<String,List<Track>> albumList=artist.getValue();
			for(Map.Entry<String, List<Track>> album:albumList.entrySet()){
				System.out.println("Album Name: "+ album.getKey()+"\n");
				List<Track> allTracks=album.getValue();
				for(int k=0;k<allTracks.size();k++){
					System.out.println("--"+allTracks.get(k).getTrackName());
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MusicLibrary2 amazonLibrary=musicLibrary.getInstance();

//		System.out.println("Please Enter Command ");
//		Scanner readInput=new Scanner(System.in);
//		String command=readInput.nextLine();
//		while(!command.equals("exit")){
//			
//			String[] arguments=command.split("\\s+");
//			if(arguments.equals("add"))
//			
//			
//			
//			System.out.println("Please Enter Command ");
//			command=readInput.nextLine();
//		}
		
		//add artist bob
//		if(args.length!=0){
//			if(args[0].equals("add") && args[1].equals("artist")){
//				//String artistName=args[2];
//				amazonLibrary.addArtist(args[2]);
//				System.out.println("Artists: ");
//				
//			}
//		}
	    String kariJobe="Kari Jobe";//readInput.nextLine();
	    
		String myGodReignsAlbum="My God Reigns";
		String trueNature="True Nature of God";
		amazonLibrary.addArtist(kariJobe);

		String youAreForMe="You are for me";
		String onlyYou="Only You";
		amazonLibrary.addAlbum(kariJobe,myGodReignsAlbum);
		amazonLibrary.addTrack(kariJobe, myGodReignsAlbum, youAreForMe);
		amazonLibrary.addTrack(kariJobe, myGodReignsAlbum, onlyYou);
		
		String panam="Panam Percy-Paul";
		String panamAlbum="His Excellency";
		String onlyHeRegins="The Lord Reigns";
		String worthy="Thou Art Worthy";
		amazonLibrary.addAlbum(panam, panamAlbum);
		amazonLibrary.addTrack(panam, panamAlbum, onlyHeRegins);
		amazonLibrary.addTrack(panam, panamAlbum,worthy);
		//System.out.println("All artists:");
		amazonLibrary.getAllArtists();
		amazonLibrary.getAllTracks();
		amazonLibrary.listTracksOnAlbum("Wiggle","LightsOut");
		amazonLibrary.listTracksOnAlbum(kariJobe, "His Excellency");
		amazonLibrary.listTracksOnAlbum(panam, "His Excellency");
		
		amazonLibrary.getAlbumsByArtist("kariJo");
		amazonLibrary.addAlbum(kariJobe,trueNature);
		amazonLibrary.getAlbumsByArtist(kariJobe);
		System.out.println(amazonLibrary.trackExists("The Lord Reigns", panamAlbum, panam));
		
		amazonLibrary.listenToTrack(youAreForMe, myGodReignsAlbum, kariJobe);
		amazonLibrary.listenToTrack("The Lord Reigns", "His Excellency", "Panam Percy-Paul");
		amazonLibrary.listenToTrack("Only You", "My God Reigns", kariJobe);
		amazonLibrary.listenToTrack(youAreForMe, myGodReignsAlbum, kariJobe);
		amazonLibrary.listenToTrack("The Lord Reigns", "His Excellency", "Panam Percy-Paul");
		amazonLibrary.listenToTrack(youAreForMe, myGodReignsAlbum, kariJobe);
		amazonLibrary.listenToTrack("The Lord Reigns", "His Excellency", "Panam Percy-Paul");
		amazonLibrary.listenToTrack("The Lord Reigns", "His Excellency", "Panam Percy-Paul");
		amazonLibrary.listenToTrack(onlyYou, myGodReignsAlbum, kariJobe);
		System.out.println("Listing top tracks");
		//amazonLibrary.listTopTracks();
	}
	
	
	class ValueComparator implements Comparator<String> {

	    HashMap<String, Track> base;
	    public ValueComparator(HashMap<String, Track> base) {
	        this.base = base;
	    }

	    // Note: this comparator imposes orderings that are inconsistent with equals.    
	    public int compare(String a, String b) {
	        if (base.get(a).getPlayCount() >= base.get(b).getPlayCount()) {
	            return -1;
	        } else {
	            return 1;
	        } // returning 0 would merge keys
	    }
	}
}
