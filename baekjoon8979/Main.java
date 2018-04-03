package baekjoon8979;
/* [����]
�ø����� ������ ���ǰ� �ֱ⿡ ���������δ� ������ ������ ������ �ʴ´�. �׷���, ���� ������� �ڽ��� ������
�󸶳� �� �ϴ����� ������ ���� ������ ����������δ� ������ ������ ���ϰ� �ִ�. �� ���� ���� ���� ��, ��, 
���޴� ���� �־�����, ���� ���� ��Ģ�� ���� ��� ���� �� ���ߴ��� �����Ѵ�.

�ݸ޴� ���� �� ���� ���� 
�ݸ޴� ���� ������, ���޴� ���� �� ���� ����
��, ���޴� ���� ��� ������, ���޴� ���� �� ���� ���� 
�� ������ 1���� N ������ ������ ǥ���ȴ�. �� ������ ����� (�ڽź��� �� ���� ���� ��) + 1�� ���ǵȴ�. ���� �� ���� 
��, ��, ���޴� ���� ��� ���ٸ� �� ������ ����� ����. ���� ���, 1�� ������ �ݸ޴� 1��, ���޴� 1���� �����, 2�� ����
�� 3�� ������ ��� ���޴� 1���� �������, 4�� ������ �޴��� ���� ���Ͽ��ٸ�, 1�� ������ 1��, 2�� ������ 3�� ������ 
���� 2��, 4�� ������ 4���� �ȴ�. �� ��� 3���� ����. 

�� ������ ��, ��, ���޴� ������ �Է¹޾Ƽ�, ��� ������ �� ���� �ߴ��� �˷��ִ� ���α׷��� �ۼ��Ͻÿ�. 
 */

/* [�Է�]
 �Է��� ù ���� ������ �� N(1 �� N �� 1,000)�� ����� �˰� ���� ���� K(1 �� K �� N)�� ��ĭ�� ���̿� �ΰ� �־�����.
 �� ������ 1���� N ������ ������ ǥ���ȴ�. ���� N���� �� �ٿ��� ���ʴ�� �� ������ ��Ÿ���� ������ �� ������  ���� 
 ��, ��, ���޴��� ���� ��ĭ�� ���̿� �ΰ� �־�����. ��ü �޴� ���� ������ 1,000,000 �����̴�.
 */

/*
����� �� �� ���̸�, �Է¹��� ���� K�� ����� �ϳ��� ������ ����Ѵ�. ����� �ݵ�� �������� ���ǵ� ����� ����� �Ѵ�. 
 */

/*
 �� ���� ��ȣ�� �޴� ���� ��ü�� ����Ʈ�� ������ �� ��>��>�� ������ �����Ͽ� ã���� �ϴ� ������ ������ ī��Ʈ �ϸ� �ȴ�.
 ��ü�� �÷���, ��ü�� �����ϱ� ���� compare���� ����ؾ� �ϴ� ���̵��� �ִ� ������� �����Ѵ�.
 Ư��, �ԷµǴ� ���� ���� ������ ��ȣ�� 1~N(��ü ������) ���� �����Ǿ� �޴� ������ �Բ� �Է� �ȴ�. �̴� �Էµ� ������
 ���� ��ȣ�� �ƴ� �� �ִٴ� ����̹Ƿ� �ܼ��� 1���� �迭�� �ε����� ���� ��ȣ�� �ű��� �ʵ��� ��������..
 �Ʒ� ���� �ؼ������� �޴� ���� ������ ���ھ��� ǥ���ϵ��� �ϰڴ�.
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
        int ranking=1;															// ���� ���� ��ũ ī��Ʈ �ϱ� ���� �ʱ�ȭ
        int targetIndex=0;														// ���ھ� �� ���� �� ��ǥ ������ �ε����� �����ϱ� ���� ����
        String targetScore;														// ���� ����� ���� ��ǥ ������ ���ھ �����Ѵ�.
        int totalCountry = Integer.parseInt(st.nextToken());				// ��ü ������ ��.. �迭�� �Ѵٸ� �迭�� ũ�Ⱑ �ǰ����� ������ ArrayList�� �Է¹ޱ� ���� ���ڿ� �Ұ�
        int targetCountry = Integer.parseInt(st.nextToken());				// ��ǥ ������ ��ȣ
        ArrayList<Country> country = new ArrayList<>();					// ���� ��ü�� �����ϱ� ���� ArrayList
        for(int i = 0; i<totalCountry; i++) {									// ��ü ���� �� ���� �Է� �ޱ� ���� �ݺ���
        	st = new StringTokenizer(br.readLine());
        	country.add(new Country(Integer.parseInt(st.nextToken()), 
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken()),
        			Integer.parseInt(st.nextToken() ) ) );
        }
        Collections.sort(country, new CountryComparatorByScore());		// ������ ���ھ�� �����Ѵ�
        targetIndex = country.indexOf(new Country(targetCountry));		// ArrayList���� ��ǥ ������ �ε����� �˾Ƴ��� ���� ���� ���� ��ȣ�� ���� �� ��ü�� �����Ͽ� ���ڷ� �־���.
        targetScore = country.get(targetIndex).toString();					// �˾Ƴ� �ε����� ��ǥ ������ ���ھ �޾ƿ´�
        for(int i = 0; i<targetIndex; i++){
        	if(country.get(i).toString().equals(targetScore))					// 1���� ���� ��ǥ �������� �ݺ��Ͽ� �� ���� ���� ���ھ ������ ����������.
        		break;
        	else
        		ranking++;														// ���ھ �ٸ��ٸ� ��ǥ ������ ������ �ϳ� ���� ��Ų��..(���� ������ �� ��ŭ ����� ��� ������ ��ǥ
        }																			// ������ ���ھ ���� �� ���� ����� �ø��� �ȴ�.. �߿��Ѱ� ���ھ ������ �ȴٴ� ��..	
        System.out.println(ranking);
        br.close();
	}
}

class Country {																	// �Է¹޴� ���� ��ü.. ��ȣ�� �� �޴��� ������ �����Ѵ�.
	int num;
	int gold;
	int silver;
	int copper;
	public Country(){
		super();
	}
	public Country(int num){													// ArrayList���� ��ǥ ������ �ε����� �˾Ƴ� �� ���ڷ� �ִ� ��ü�� ���� ��ȣ�� ������ ������ �ȴ�.
		this.num = num;
	}
	public Country(int num, int gold, int silver, int copper) {
		this.num = num;
		this.gold = gold;
		this.silver = silver;
		this.copper = copper;
	}
	@Override
	public boolean equals(Object obj) {										// ArrayList���� indexOf�� ����� �� ��ü �� �񱳸� equals�� �Ѵ�.. �������̵��Ͽ� num���� ���ϵ��� ������.
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
	public String toString(){													// equals�� num�� ���ϹǷ� toString�� �̿��� ���ھ ������.. ���� ����� �޴޵� ����.. 
		return this.gold + "" + this.silver + "" + this.copper;				// �̹� ������ �� �� ���ϱ� ������ ���� �ƴ� ���� ���·� �������� ���ϸ� �ȴ�.
	}
}

class CountryComparatorByScore implements Comparator<Country> {	// ArrayList�� ���� �� �� ����ϴ� compare �Լ��� ������ ��ü.. 
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