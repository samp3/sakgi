Ohjelman Board luokka kuvaa pelilautaa 8x8 taulukkona. Pelinappulat ovat merkattu seuraavasti: P ja p vastaavat sotilasta, 

K ja k vastaavat heppaa, Q ja q vastaavat kuningatarta, B ja b vastaavat lähettiä, R ja r vastaavat tornia sekä A ja a vastaavat kuningasta. 

Isot kirjaimet ovat aina sen, kenen vuoro on sillä hetkellä ja pienet vastustajan. Boardilla on flip() metodi joka kääntää pöydän ympäri sekä pienet kirjaimet isoiksi ja toisinpäin.

Boardin getAllLegalMoves() palauttaa String jonon, jossa on kaikki mahdolliset siirrot kyseisellä Board tilanteella. Tähän String:iin vertaan pelaajan syöttämää 

siirtoa, onko se sallittu. getAllLegalMoves() käy yksitellen ruudut läpi ja tarkistaa siellä sijaitsevan nappulan siirtomahdollisuudet. Nämä algoritmit löytyvät kaikille nappuloille movealgorithms paketista.

Siirroissa on poikkeustilanteita, mutta pääasiassa siirrot ovat muotoa y1,x1,y2,y3,syöty nappula tai välilyönti. Esimerkiksi jos haluan siirtää tornin paikasta 4,4 --> 4,5 ja syödä sotilaan, 

on siirto muotoa 4445p. Huom syöty nappula on aina pienellä kirjaimella, koska vuorontekijän nappulat ovat kaikki UPPERCASE.

 Siirrot tehdään luokassa MakeMove metodilla makeMove(String siirto). Se siirtää nappulan halutulle paikalle ja asettaa vanhan paikan tyhjäksi. 

ChessInterface luokka hoitaa piirtämisen sekä pelaajan syötteen vastaanottamisen ja analysoimisen. Nämä otetaan MouseListenerin kanssa talteen. Tärkeitä metodeita on refresh(), joka päivittää tilanteen pöydällä jokaisen sallitun siirron jälkeen. PaintComponent, joka piirtää kaiken pöydälle. setUp, joka tekee valmistelut JFramen ja mouselistenerin kanssa, että

 piirtäminen ja siirtäminen onnistuu. 

Game luokasta luodaan ChessInterace ja käynnistetään peli. 

Tein KingSafety luokkaa, mutta se jäi sen verran rikkonaiseksi, että päätin pistää sen palauttamaan aina true totuusarvon. Nyt siis on pelaajan tehtävänä huomioida tekeekö hän ei-sallitun siirron. 

Tämän luokan tarkoituksena on tarkistaa, tekeekö kyseinen siirto oman kuninkaan uhatuksi ja jos tekee, niin ei lisää kyseistä siirtoa legalMoves listaan. GraphicalChessBoard rajapinta on ainoastaan sen takia, että pelin pystyy porttaamaan vaikka androidille myöhemmin.