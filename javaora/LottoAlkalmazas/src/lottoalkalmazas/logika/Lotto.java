package lottoalkalmazas.logika;

import java.util.ArrayList;

public class Lotto {
    private ArrayList<Integer> lottoszamok;
    private int maxLottoSzam;
    private int LottoTipus;

    public Lotto(int LottoTipus) {
        this.LottoTipus = LottoTipus;
        this.lottoszamok = new ArrayList();
        ujLotto(this.LottoTipus);
    }
    
    public void ujLotto(int LottoTipus){
        this.LottoTipus = LottoTipus;
        switch(this.LottoTipus){
            case 5:
                this.maxLottoSzam = 90; break;
            case 6:
                this.maxLottoSzam = 45; break;
            case 7:
                this.maxLottoSzam = 35; break;
        }
    }
    
    public void Sorsol(){
        while(lottoszamok.size() < this.LottoTipus){
            int szam = (int) (Math.random()*maxLottoSzam)+1;
            if(!lottoszamok.contains(szam)){
                lottoszamok.add(szam);
            }
        }
    }
    
    public void Rendez(){
        lottoszamok.sort(Integer :: compareTo);
    }

    @Override
    public String toString() {
        String s = "";
        for (Integer integer : lottoszamok) {
            s += integer + " ";
        }
        return s;
    }
}
