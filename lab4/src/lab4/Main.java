package lab4;

//Am ramas cu restanta de la laboratorul 4 cu ultima bulina de la compulsory si ati zis ca daca nu m-ati punctat, sa va arat urmatorul laborator,
//respectiv sa va trimit codul sursa

// mi-a rulat doar primesc niste mesaje de exceptie, nu am reusit sa le dau de capat

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		
		Resident[] r=IntStream.rangeClosed(0,4)//valori de la 0 la 3
					   .mapToObj(i->new Resident("R"+i))//fac cate obiecte vreau
					   .toArray(Resident[]::new);//muta-le intr-un array de tip Resident
		
		List<Resident> residentList=new ArrayList<>();
		residentList.addAll(Arrays.asList(r));
		
		Collections.sort(residentList, Comparator.comparing(Resident::getName));
		System.out.println(residentList);

//-------------------------am facut o lista de rezidenti------------------------------
		
		
		
//-------------------------------pt HOSPITAL--------------------------------------
		
		Hospital[] h=IntStream.rangeClosed(0, 4)
							  .mapToObj(i->new Hospital(5,"H"+i))
							  .toArray(Hospital[]::new);
							  
		Set<Hospital>  hospitalList=new TreeSet<>();
		hospitalList.addAll(Arrays.asList(h));
		
		//Collections.sort(hospitalList, Comparator.comparing(Hospital::getName));
		System.out.println(hospitalList);
		
		Map<Resident, List<Hospital>> resPrefMap = new HashMap<>();
		resPrefMap.put(r[0], Arrays.asList(h[0], h[1], h[2]));
		resPrefMap.put(r[1], Arrays.asList(h[0], h[1],h[2]));
        resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
        resPrefMap.put(r[3], Arrays.asList(h[0],h[2]));
        //din slide

		
        Map<Hospital, List<Resident>> hosPrefMap = new TreeMap<>();

        hosPrefMap.put(h[0], Arrays.asList(r[3], r[0], r[1], r[2]));
        hosPrefMap.put(h[1], Arrays.asList(r[0], r[2], r[1]));
        hosPrefMap.put(h[2], Arrays.asList(r[0], r[1], r[3]));
        
        residentList.stream()
        .filter(res -> resPrefMap.get(res).contains(h[0]))
        .forEach(System.out::println);

       
        List<Hospital> target = Arrays.asList(h[0], h[2]);
        List<Resident> result;
                result = residentList.stream()
                        .filter(res -> resPrefMap.get(res).containsAll(target))
                        .collect(Collectors.toList());
                //din slide
                
        for(int i=0;i<result.size();i++)
                    System.out.println(result.get(i));
	}

}
