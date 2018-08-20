package Siker.Sprzedajemy;

public enum SprzedajemySorting
{
    PRICE_ASCENDING( "inp_srt_price_a" ), PRICE_DESCENDING( "inp_srt_price_d" ), NEWEST(
                "inp_srt_date_d" );

    private final String sorting;


    SprzedajemySorting( String sorting )
    {
        this.sorting = sorting;
    }


    String getSorting()
    {
        return this.sorting;
    }
}
