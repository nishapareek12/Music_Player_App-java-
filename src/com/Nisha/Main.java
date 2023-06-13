package com.Nisha;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();
    public static void main(String[] args) {

        Album album1 = new Album("album1","AR rahman");
        album1.addSong("Dilse",5.0);
        album1.addSong("Jay ho",5.5);
        album1.addSong("chaiya chaiya",4.0);
        album1.addSong("mitva",4.5);

         Album album2 = new Album("album2","K K");
        album2.addSong("sach keh raha hai",5.0);
        album2.addSong("yaaro dosti ",5.5);
        album2.addSong("aankho mai teri",4.0);
        album2.addSong("kaise mujhe",5.0);

        albums.add(album1);
        albums.add(album2);
        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Dilse",playList_1);
        albums.get(0).addToPlayList("jay ho",playList_1);
        albums.get(0).addToPlayList("mitva",playList_1);
        albums.get(1).addToPlayList("sach keh raha hai",playList_1);
        albums.get(1).addToPlayList("yaaro dosti",playList_1);

        play(playList_1);


    }
    private static void play(LinkedList<Song> playList){
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();

        if(playList.size() == 0){
            System.out.println("this playlist has  no song");
        }
        else{
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }
        while(!quit){
            int action = sc.nextInt();
            sc.nextLine();

            switch(action){
                case 0 :
                    System.out.println("playlist complete");
                    quit = true;
                    break;

                case 1:
                    if(!forward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if(listIterator.hasNext()){
                        System.out.println("Now playing" + listIterator.next().toString());
                    } else {
                        System.out.println("no songs available, reached end of list");
                        forward = false;
                    }
                    break;
                case 2:
                    if(forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now playing "+listIterator.previous().toString());
                    }else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 3:
                    if(forward){
                        if(listIterator.hasPrevious()){
                            System.out.println("Now playing "+listIterator.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() >0){
                        listIterator.remove();
                        if(listIterator.hasNext()){
                            System.out.println("now playing "+listIterator.next().toString());
                        }
                        else {
                            if(listIterator.hasPrevious())
                                System.out.println("now playing "+listIterator.previous().toString());
                        }
                    }
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Available options\n press");
        System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song > playList){
        ListIterator<Song>  iterator = playList.listIterator();
        System.out.println("________________________");

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("_________________________");
    }
}
