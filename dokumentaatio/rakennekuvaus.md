Ohjelman Board luokka kuvaa pelilautaa 8x8 taulukkona. Pelinappulat ovat merkattu seuraavasti: P ja p vastaavat sotilasta, 

K ja k vastaavat heppaa, Q ja q vastaavat kuningatarta, B ja b vastaavat l�hetti�, R ja r vastaavat tornia sek� A ja a vastaavat kuningasta. 

Isot kirjaimet ovat aina sen, kenen vuoro on sill� hetkell� ja pienet vastustajan. Boardilla on flip() metodi joka k��nt�� p�yd�n ymp�ri sek� pienet kirjaimet isoiksi ja toisinp�in.

Boardin getAllLegalMoves() palauttaa String jonon, jossa on kaikki mahdolliset siirrot kyseisell� Board tilanteella. T�h�n String:iin vertaan pelaajan sy�tt�m�� 

siirtoa, onko se sallittu. getAllLegalMoves() k�y yksitellen ruudut l�pi ja tarkistaa siell� sijaitsevan nappulan siirtomahdollisuudet. N�m� algoritmit l�ytyv�t kaikille nappuloille movealgorithms paketista.

Siirroissa on poikkeustilanteita, mutta p��asiassa siirrot ovat muotoa y1,x1,y2,y3,sy�ty nappula tai v�lily�nti. Esimerkiksi jos haluan siirt�� tornin paikasta 4,4 --> 4,5 ja sy�d� sotilaan, 

on siirto muotoa 4445p. Huom sy�ty nappula on aina pienell� kirjaimella, koska vuorontekij�n nappulat ovat kaikki UPPERCASE.

 Siirrot tehd��n luokassa MakeMove metodilla makeMove(String siirto). Se siirt�� nappulan halutulle paikalle ja asettaa vanhan paikan tyhj�ksi. 

ChessInterface luokka hoitaa piirt�misen sek� pelaajan sy�tteen vastaanottamisen ja analysoimisen. N�m� otetaan MouseListenerin kanssa talteen. T�rkeit� metodeita on refresh(), joka p�ivitt�� tilanteen p�yd�ll� jokaisen sallitun siirron j�lkeen. PaintComponent, joka piirt�� kaiken p�yd�lle. setUp, joka tekee valmistelut JFramen ja mouselistenerin kanssa, ett�

 piirt�minen ja siirt�minen onnistuu. 

Game luokasta luodaan ChessInterace ja k�ynnistet��n peli. 

Tein KingSafety luokkaa, mutta se j�i sen verran rikkonaiseksi, ett� p��tin pist�� sen palauttamaan aina true totuusarvon. Nyt siis on pelaajan teht�v�n� huomioida tekeek� h�n ei-sallitun siirron. 

T�m�n luokan tarkoituksena on tarkistaa, tekeek� kyseinen siirto oman kuninkaan uhatuksi ja jos tekee, niin ei lis�� kyseist� siirtoa legalMoves listaan. GraphicalChessBoard rajapinta on ainoastaan sen takia, ett� pelin pystyy porttaamaan vaikka androidille my�hemmin.