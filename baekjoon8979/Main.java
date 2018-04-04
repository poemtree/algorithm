package baekjoon8979;
/* [문제]
올림픽은 참가에 의의가 있기에 공식적으로는 국가간 순위를 정하지 않는다. 그러나, 많은 사람들이 자신의 국가가
얼마나 잘 하는지에 관심이 많기 때문에 비공식적으로는 국가간 순위를 정하고 있다. 두 나라가 각각 얻은 금, 은, 
동메달 수가 주어지면, 보통 다음 규칙을 따라 어느 나라가 더 잘했는지 결정한다.

금메달 수가 더 많은 나라 
금메달 수가 같으면, 은메달 수가 더 많은 나라
금, 은메달 수가 모두 같으면, 동메달 수가 더 많은 나라 
각 국가는 1부터 N 사이의 정수로 표현된다. 한 국가의 등수는 (자신보다 더 잘한 나라 수) + 1로 정의된다. 만약 두 나라가 
금, 은, 동메달 수가 모두 같다면 두 나라의 등수는 같다. 예를 들어, 1번 국가가 금메달 1개, 은메달 1개를 얻었고, 2번 국가
와 3번 국가가 모두 은메달 1개를 얻었으며, 4번 국가는 메달을 얻지 못하였다면, 1번 국가가 1등, 2번 국가와 3번 국가가 
공동 2등, 4번 국가가 4등이 된다. 이 경우 3등은 없다. 

각 국가의 금, 은, 동메달 정보를 입력받아서, 어느 국가가 몇 등을 했는지 알려주는 프로그램을 작성하시오. 
 */

/* [입력]
 입력의 첫 줄은 국가의 수 N(1 ≤ N ≤ 1,000)과 등수를 알고 싶은 국가 K(1 ≤ K ≤ N)가 빈칸을 사이에 두고 주어진다.
 각 국가는 1부터 N 사이의 정수로 표현된다. 이후 N개의 각 줄에는 차례대로 각 국가를 나타내는 정수와 이 국가가  얻은 
 금, 은, 동메달의 수가 빈칸을 사이에 두고 주어진다. 전체 메달 수의 총합은 1,000,000 이하이다.
 */

/* [출력]
출력은 단 한 줄이며, 입력받은 국가 K의 등수를 하나의 정수로 출력한다. 등수는 반드시 문제에서 정의된 방식을 따라야 한다. 
 */

/*
 각 국가 번호와 메달 쌍의 객체를 리스트에 저장한 뒤 금>은>동 순으로 정렬하여 찾고자 하는 국가의 순위를 카운트 하면 된다.
 객체와 컬렉션, 객체를 정렬하기 위한 compare까지 고려해야 하는 난이도가 있는 문제라고 생각한다.
 특히, 입력되는 값을 보면 국가의 번호가 1~N(전체 국가수) 까지 배정되어 메달 갯수와 함께 입력 된다. 이는 입력된 순서가
 국가 번호가 아닐 수 있다는 얘기이므로 단순히 1차원 배열의 인덱스로 국가 번호를 매기지 않도록 조심하자..
 아래 문제 해설에서는 메달 수를 간단히 스코어라고 표현하도록 하겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ranking=1;															// 가장 낮은 랭크 카운트 하기 위한 초기화
        int targetIndex=0;														// 스코어 순 정렬 후 목표 국가의 인덱스를 저장하기 위한 변수
        String targetScore;														// 순위 계산을 위해 목표 국가의 스코어를 저장한다.
        int totalCountry = Integer.parseInt(st.nextToken());				// 전체 국가의 수.. 배열로 한다면 배열의 크기가 되겠지만 지금은 ArrayList를 입력받기 위한 숫자에 불과
        int targetCountry = Integer.parseInt(st.nextToken());				// 목표 국가의 번호
        ArrayList<Country> country = new ArrayList<>();					// 국가 객체를 저장하기 위한 ArrayList
        for(int i = 0; i<totalCountry; i++) {									// 전체 국가 수 까지 입력 받기 위한 반복문
        	st = new StringTokenizer(br.readLine());
        	country.add(new Country(Integer.parseInt(st.nextToken()), 
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken() ) ) );
        }
        Collections.sort(country, new CountryComparatorByScore());		// 국가를 스코어로 정렬한다
        targetIndex = country.indexOf(new Country(targetCountry));		// ArrayList에서 목표 국가의 인덱스를 알아내기 위해 같은 국가 번호를 갖는 빈 객체를 생성하여 인자로 넣었다.
        targetScore = country.get(targetIndex).toString();					// 알아낸 인덱스로 목표 국가의 스코어를 받아온다
        for(int i = 0; i<targetIndex; i++){
        	if(country.get(i).toString().equals(targetScore))					// 1순위 부터 목표 국가까지 반복하여 그 전에 같은 스코어가 있으면 빠져나간다.
        		break;
        	else
        		ranking++;														// 스코어가 다르다면 목표 국가의 순위를 하나 증가 시킨다..(동률 국가의 수 만큼 등수가 비기 때문에 목표
        }																			// 국가의 스코어가 나올 때 가지 등수를 올리면 된다.. 중요한건 스코어만 같으면 된다는 것..	
        System.out.println(ranking);
        br.close();
	}
}

class Country {																	// 입력받는 국가 객체.. 번호와 각 메달의 갯수를 저장한다.
	int num;
	int gold;
	int silver;
	int copper;
	public Country(){
		super();
	}
	public Country(int num){													// ArrayList에서 목표 국가의 인덱스를 알아낼 때 인자로 넣는 객체는 국가 번호만 가지고 있으면 된다.
		this.num = num;
	}
	public Country(int num, int gold, int silver, int copper) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.copper = copper;
	}
	@Override
	public boolean equals(Object obj) {										// ArrayList에서 indexOf를 사용할 때 객체 간 비교를 equals로 한다.. 오버라이드하여 num으로 비교하도록 만들자.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		if (num != other.num)
			return false;
		return true;
	}
	@Override
	public String toString(){													// equals는 num을 비교하므로 toString을 이용해 스코어를 비교하자.. 같은 등수면 메달도 같다.. 
		return this.gold + "" + this.silver + "" + this.copper;				// 이미 정렬을 한 뒤 비교하기 때문에 수가 아닌 문자 형태로 같은지만 비교하면 된다.
	}
}

class CountryComparatorByScore implements Comparator<Country> {	// ArrayList를 정렬 할 때 사용하는 compare 함수를 정의한 객체.. 
	 @Override
	    public int compare(Country thisCountry, Country otherCountry) {
	    	if(thisCountry.gold!=otherCountry.gold)
	    		return otherCountry.gold - thisCountry.gold;
	    	else {
	    		if(thisCountry.silver!=otherCountry.silver)
	    			return otherCountry.silver - thisCountry.silver;
	    		else {
	    			if(thisCountry.copper!=otherCountry.copper)
	    				return otherCountry.copper - thisCountry.copper;
	    			else
	    				return 0;
	    		}
	 
	    	}
	 }
}
