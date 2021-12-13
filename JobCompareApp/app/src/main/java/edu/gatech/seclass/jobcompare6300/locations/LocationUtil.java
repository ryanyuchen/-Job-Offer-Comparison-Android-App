package edu.gatech.seclass.jobcompare6300.locations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class LocationUtil {

  public static final List<Location> ALL_LOCATIONS =
      Collections.unmodifiableList(
          Arrays.stream(Location.values())
              .sorted(Comparator.comparing(Location::getName))
              .collect(Collectors.toList()));

  public static final double BASELINE_COST_OF_LIVING =
      Location.NEW_YORK_NY_UNITED_STATES.getCostOfLiving();

  private LocationUtil() {
  }

  public enum Location {
    HAMILTON_BERMUDA("Hamilton, Bermuda", 137.56),
    ZURICH_SWITZERLAND("Zurich, Switzerland", 128.65),
    BASEL_SWITZERLAND("Basel, Switzerland", 126.89),
    LAUSANNE_SWITZERLAND("Lausanne, Switzerland", 119.62),
    BERN_SWITZERLAND("Bern, Switzerland", 118.42),
    GENEVA_SWITZERLAND("Geneva, Switzerland", 118.33),
    REYKJAVIK_ICELAND("Reykjavik, Iceland", 112.57),
    LUGANO_SWITZERLAND("Lugano, Switzerland", 111.88),
    STAVANGER_NORWAY("Stavanger, Norway", 111),
    OSLO_NORWAY("Oslo, Norway", 107.14),
    BERGEN_NORWAY("Bergen, Norway", 102.87),
    NEW_YORK_NY_UNITED_STATES("New York, NY, United States", 100),
    TRONDHEIM_NORWAY("Trondheim, Norway", 99.73),
    SAN_FRANCISCO_CA_UNITED_STATES("San Francisco, CA, United States", 96.88),
    HONOLULU_HI_UNITED_STATES("Honolulu, HI, United States", 93.72),
    ANCHORAGE_AK_UNITED_STATES("Anchorage, AK, United States", 93.19),
    BROOKLYN_NY_UNITED_STATES("Brooklyn, NY, United States", 90.31),
    WASHINGTON_DC_UNITED_STATES("Washington, DC, United States", 88.5),
    SANTA_ROSA_CA_UNITED_STATES("Santa Rosa, CA, United States", 88.27),
    COPENHAGEN_DENMARK("Copenhagen, Denmark", 87.91),
    CHARLESTON_SC_UNITED_STATES("Charleston, SC, United States", 86.87),
    LUXEMBOURG_LUXEMBOURG("Luxembourg, Luxembourg", 86.85),
    BELLEVUE_WA_UNITED_STATES("Bellevue, WA, United States", 85.97),
    SEATTLE_WA_UNITED_STATES("Seattle, WA, United States", 85.51),
    TOKYO_JAPAN("Tokyo, Japan", 84.78),
    PARIS_FRANCE("Paris, France", 84.68),
    ODENSE_DENMARK("Odense, Denmark", 84.09),
    BERKELEY_CA_UNITED_STATES("Berkeley, CA, United States", 84.09),
    JERSEY_CITY_NJ_UNITED_STATES("Jersey City, NJ, United States", 84.08),
    AALBORG_DENMARK("Aalborg, Denmark", 82.21),
    AMSTERDAM_NETHERLANDS("Amsterdam, Netherlands", 82.14),
    SEOUL_SOUTH_KOREA("Seoul, South Korea", 81.96),
    ARHUS_DENMARK("Arhus, Denmark", 81.94),
    LONDON_UNITED_KINGDOM("London, United Kingdom", 81.31),
    OAKLAND_CA_UNITED_STATES("Oakland, CA, United States", 81.18),
    HELSINKI_FINLAND("Helsinki, Finland", 80.6),
    BOSTON_MA_UNITED_STATES("Boston, MA, United States", 80.46),
    SINGAPORE_SINGAPORE("Singapore, Singapore", 80.4),
    DUBLIN_IRELAND("Dublin, Ireland", 80.28),
    SYDNEY_AUSTRALIA("Sydney, Australia", 79.93),
    HARTFORD_CT_UNITED_STATES("Hartford, CT, United States", 79.85),
    ALBANY_NY_UNITED_STATES("Albany, NY, United States", 79.38),
    PHILADELPHIA_PA_UNITED_STATES("Philadelphia, PA, United States", 79.25),
    TAMPERE_FINLAND("Tampere, Finland", 79.04),
    MILTON_KEYNES_UNITED_KINGDOM("Milton Keynes, United Kingdom", 78.5),
    GRENOBLE_FRANCE("Grenoble, France", 78.43),
    IRVINE_CA_UNITED_STATES("Irvine, CA, United States", 78.38),
    LYON_FRANCE("Lyon, France", 78),
    LONG_BEACH_CA_UNITED_STATES("Long Beach, CA, United States", 77.95),
    LINZ_AUSTRIA("Linz, Austria", 77.8),
    LOS_ANGELES_CA_UNITED_STATES("Los Angeles, CA, United States", 77.66),
    TEL_AVIV_YAFO_ISRAEL("Tel Aviv-Yafo, Israel", 77.39),
    BARRIE_CANADA("Barrie, Canada", 77.37),
    CHICAGO_IL_UNITED_STATES("Chicago, IL, United States", 77.33),
    STOCKHOLM_SWEDEN("Stockholm, Sweden", 77.23),
    FLORENCE_ITALY("Florence, Italy", 77.21),
    BOULDER_CO_UNITED_STATES("Boulder, CO, United States", 77.16),
    THE_HAGUE_DEN_HAAG_NETHERLANDS("The Hague (Den Haag), Netherlands", 76.75),
    READING_UNITED_KINGDOM("Reading, United Kingdom", 76.73),
    AUCKLAND_NEW_ZEALAND("Auckland, New Zealand", 76.63),
    JERUSALEM_ISRAEL("Jerusalem, Israel", 76.62),
    BORDEAUX_FRANCE("Bordeaux, France", 76.31),
    UTRECHT_NETHERLANDS("Utrecht, Netherlands", 76.3),
    TOULOUSE_FRANCE("Toulouse, France", 76.3),
    SAN_JOSE_CA_UNITED_STATES("San Jose, CA, United States", 76.28),
    BURLINGTON_VT_UNITED_STATES("Burlington, VT, United States", 76.11),
    PITTSBURGH_PA_UNITED_STATES("Pittsburgh, PA, United States", 76.04),
    NICE_FRANCE("Nice, France", 75.84),
    MIAMI_FL_UNITED_STATES("Miami, FL, United States", 75.83),
    BRUSSELS_BELGIUM("Brussels, Belgium", 75.69),
    GRAZ_AUSTRIA("Graz, Austria", 75.61),
    SANTA_BARBARA_CA_UNITED_STATES("Santa Barbara, CA, United States", 75.55),
    SACRAMENTO_CA_UNITED_STATES("Sacramento, CA, United States", 75.54),
    STRASBOURG_FRANCE("Strasbourg, France", 75.47),
    GENOA_ITALY("Genoa, Italy", 75.38),
    GENT_BELGIUM("Gent, Belgium", 75.27),
    PERTH_AUSTRALIA("Perth, Australia", 75.09),
    ANTWERP_BELGIUM("Antwerp, Belgium", 74.88),
    PORTLAND_ME_UNITED_STATES("Portland, ME, United States", 74.81),
    WEST_PALM_BEACH_FL_UNITED_STATES("West Palm Beach, FL, United States", 74.79),
    HONG_KONG_HONG_KONG("Hong Kong, Hong Kong", 74.73),
    INNSBRUCK_AUSTRIA("Innsbruck, Austria", 74.66),
    LEUVEN_BELGIUM("Leuven, Belgium", 74.58),
    LEIDEN_NETHERLANDS("Leiden, Netherlands", 74.56),
    OSAKA_JAPAN("Osaka, Japan", 74.53),
    MELBOURNE_AUSTRALIA("Melbourne, Australia", 74.53),
    BATH_UNITED_KINGDOM("Bath, United Kingdom", 74.48),
    EVERETT_WA_UNITED_STATES("Everett, WA, United States", 74.36),
    SASKATOON_CANADA("Saskatoon, Canada", 74.26),
    TACOMA_WA_UNITED_STATES("Tacoma, WA, United States", 74.21),
    PORTLAND_OR_UNITED_STATES("Portland, OR, United States", 74.17),
    ROTTERDAM_NETHERLANDS("Rotterdam, Netherlands", 74.08),
    MONTPELLIER_FRANCE("Montpellier, France", 74.08),
    ST_JOHNS_NL_CANADA("St. John's, NL, Canada", 74.05),
    MILAN_ITALY("Milan, Italy", 73.89),
    MAASTRICHT_NETHERLANDS("Maastricht, Netherlands", 73.87),
    BALTIMORE_MD_UNITED_STATES("Baltimore, MD, United States", 73.85),
    MUNICH_GERMANY("Munich, Germany", 73.79),
    ESPOO_FINLAND("Espoo, Finland", 73.78),
    NEW_ORLEANS_LA_UNITED_STATES("New Orleans, LA, United States", 73.61),
    GALWAY_IRELAND("Galway, Ireland", 73.54),
    CORK_IRELAND("Cork, Ireland", 73.53),
    PADOVA_ITALY("Padova, Italy", 73.49),
    HAIFA_ISRAEL("Haifa, Israel", 73.42),
    CHARLOTTE_NC_UNITED_STATES("Charlotte, NC, United States", 73.33),
    BURLINGTON_CANADA("Burlington, Canada", 73.13),
    ABERDEEN_UNITED_KINGDOM("Aberdeen, United Kingdom", 73.02),
    DUSSELDORF_GERMANY("Dusseldorf, Germany", 73),
    MINNEAPOLIS_MN_UNITED_STATES("Minneapolis, MN, United States", 72.93),
    ADELAIDE_AUSTRALIA("Adelaide, Australia", 72.92),
    EINDHOVEN_NETHERLANDS("Eindhoven, Netherlands", 72.82),
    CAMBRIDGE_UNITED_KINGDOM("Cambridge, United Kingdom", 72.6),
    OXFORD_UNITED_KINGDOM("Oxford, United Kingdom", 72.6),
    DARWIN_AUSTRALIA("Darwin, Australia", 72.47),
    EUGENE_OR_UNITED_STATES("Eugene, OR, United States", 72.46),
    NANTES_FRANCE("Nantes, France", 72.37),
    GRONINGEN_NETHERLANDS("Groningen, Netherlands", 72.29),
    SAN_DIEGO_CA_UNITED_STATES("San Diego, CA, United States", 72.29),
    RAMAT_GAN_ISRAEL("Ramat Gan, Israel", 72.15),
    HAMBURG_GERMANY("Hamburg, Germany", 72.15),
    BELLINGHAM_WA_UNITED_STATES("Bellingham, WA, United States", 72.14),
    ATLANTA_GA_UNITED_STATES("Atlanta, GA, United States", 72.05),
    DENVER_CO_UNITED_STATES("Denver, CO, United States", 72.02),
    SAINT_PAUL_MN_UNITED_STATES("Saint Paul, MN, United States", 71.94),
    HAMILTON_NEW_ZEALAND("Hamilton, New Zealand", 71.91),
    BIRMINGHAM_AL_UNITED_STATES("Birmingham, AL, United States", 71.87),
    FRANKFURT_GERMANY("Frankfurt, Germany", 71.64),
    WELLINGTON_NEW_ZEALAND("Wellington, New Zealand", 71.52),
    ASHEVILLE_NC_UNITED_STATES("Asheville, NC, United States", 71.52),
    TRIESTE_ITALY("Trieste, Italy", 71.51),
    FORT_MYERS_FL_UNITED_STATES("Fort Myers, FL, United States", 71.5),
    NEWCASTLE_AUSTRALIA("Newcastle, Australia", 71.42),
    PORTSMOUTH_UNITED_KINGDOM("Portsmouth, United Kingdom", 71.04),
    HALIFAX_CANADA("Halifax, Canada", 70.88),
    VIENNA_AUSTRIA("Vienna, Austria", 70.86),
    HEIDELBERG_GERMANY("Heidelberg, Germany", 70.82),
    INDIANAPOLIS_IN_UNITED_STATES("Indianapolis, IN, United States", 70.79),
    EDINBURGH_UNITED_KINGDOM("Edinburgh, United Kingdom", 70.73),
    JACKSONVILLE_FL_UNITED_STATES("Jacksonville, FL, United States", 70.62),
    BUFFALO_NY_UNITED_STATES("Buffalo, NY, United States", 70.59),
    OLYMPIA_WA_UNITED_STATES("Olympia, WA, United States", 70.57),
    SAINT_PETERSBURG_FL_UNITED_STATES("Saint Petersburg, FL, United States", 70.49),
    AUSTIN_TX_UNITED_STATES("Austin, TX, United States", 70.49),
    BRISBANE_AUSTRALIA("Brisbane, Australia", 70.46),
    MALE_MALDIVES("Male, Maldives", 70.45),
    SLIEMA_MALTA("Sliema, Malta", 70.33),
    ROCHESTER_NY_UNITED_STATES("Rochester, NY, United States", 70.25),
    CHRISTCHURCH_NEW_ZEALAND("Christchurch, New Zealand", 70.23),
    TORONTO_CANADA("Toronto, Canada", 70.19),
    ORLANDO_FL_UNITED_STATES("Orlando, FL, United States", 70.18),
    DUNEDIN_NEW_ZEALAND("Dunedin, New Zealand", 70.16),
    TURKU_FINLAND("Turku, Finland", 70.13),
    PLYMOUTH_UNITED_KINGDOM("Plymouth, United Kingdom", 70.02),
    SWINDON_UNITED_KINGDOM("Swindon, United Kingdom", 69.92),
    CANBERRA_AUSTRALIA("Canberra, Australia", 69.88),
    MANCHESTER_UNITED_KINGDOM("Manchester, United Kingdom", 69.86),
    PEORIA_IL_UNITED_STATES("Peoria, IL, United States", 69.84),
    GOTHENBURG_SWEDEN("Gothenburg, Sweden", 69.77),
    CLEVELAND_OH_UNITED_STATES("Cleveland, OH, United States", 69.65),
    VANCOUVER_CANADA("Vancouver, Canada", 69.63),
    LIMERICK_IRELAND("Limerick, Ireland", 69.63),
    BRISTOL_UNITED_KINGDOM("Bristol, United Kingdom", 69.58),
    BRIGHTON_UNITED_KINGDOM("Brighton, United Kingdom", 69.54),
    BOLOGNA_ITALY("Bologna, Italy", 69.5),
    YORK_UNITED_KINGDOM("York, United Kingdom", 69.33),
    KARLSRUHE_GERMANY("Karlsruhe, Germany", 69.26),
    RALEIGH_NC_UNITED_STATES("Raleigh, NC, United States", 69.18),
    BONN_GERMANY("Bonn, Germany", 69.14),
    HOBART_AUSTRALIA("Hobart, Australia", 69.1),
    ARLINGTON_TX_UNITED_STATES("Arlington, TX, United States", 69.07),
    ROME_ITALY("Rome, Italy", 69.03),
    SAINT_LOUIS_MO_UNITED_STATES("Saint Louis, MO, United States", 69.02),
    BREMEN_GERMANY("Bremen, Germany", 68.93),
    CALGARY_CANADA("Calgary, Canada", 68.93),
    MILWAUKEE_WI_UNITED_STATES("Milwaukee, WI, United States", 68.81),
    BRAMPTON_CANADA("Brampton, Canada", 68.79),
    NASHVILLE_TN_UNITED_STATES("Nashville, TN, United States", 68.78),
    UPPSALA_SWEDEN("Uppsala, Sweden", 68.75),
    TAMPA_FL_UNITED_STATES("Tampa, FL, United States", 68.61),
    REGINA_CANADA("Regina, Canada", 68.46),
    MANNHEIM_GERMANY("Mannheim, Germany", 68.35),
    LEEDS_UNITED_KINGDOM("Leeds, United Kingdom", 68.26),
    VIRGINIA_BEACH_VA_UNITED_STATES("Virginia Beach, VA, United States", 67.86),
    BERLIN_GERMANY("Berlin, Germany", 67.75),
    LILLE_FRANCE("Lille, France", 67.73),
    SYRACUSE_NY_UNITED_STATES("Syracuse, NY, United States", 67.55),
    STUTTGART_GERMANY("Stuttgart, Germany", 67.46),
    COQUITLAM_CANADA("Coquitlam, Canada", 67.43),
    RED_DEER_CANADA("Red Deer, Canada", 67.42),
    COLOGNE_GERMANY("Cologne, Germany", 67.36),
    AACHEN_GERMANY("Aachen, Germany", 67.33),
    TALLAHASSEE_FL_UNITED_STATES("Tallahassee, FL, United States", 67.24),
    BAKERSFIELD_CA_UNITED_STATES("Bakersfield, CA, United States", 67.11),
    ANN_ARBOR_MI_UNITED_STATES("Ann Arbor, MI, United States", 67.06),
    NOTTINGHAM_UNITED_KINGDOM("Nottingham, United Kingdom", 67.05),
    EDMONTON_CANADA("Edmonton, Canada", 67.03),
    LAS_VEGAS_NV_UNITED_STATES("Las Vegas, NV, United States", 66.98),
    COLUMBUS_OH_UNITED_STATES("Columbus, OH, United States", 66.9),
    TURIN_ITALY("Turin, Italy", 66.68),
    SPOKANE_WA_UNITED_STATES("Spokane, WA, United States", 66.6),
    KELOWNA_CANADA("Kelowna, Canada", 66.6),
    EXETER_UNITED_KINGDOM("Exeter, United Kingdom", 66.56),
    GLASGOW_UNITED_KINGDOM("Glasgow, United Kingdom", 66.5),
    MEMPHIS_TN_UNITED_STATES("Memphis, TN, United States", 66.49),
    KINGSTON_CANADA("Kingston, Canada", 66.45),
    NUREMBERG_GERMANY("Nuremberg, Germany", 66.44),
    COVENTRY_UNITED_KINGDOM("Coventry, United Kingdom", 66.31),
    COLUMBIA_SC_UNITED_STATES("Columbia, SC, United States", 66.23),
    VICTORIA_CANADA("Victoria, Canada", 66.17),
    MALMO_SWEDEN("Malmo, Sweden", 66.14),
    SALEM_OR_UNITED_STATES("Salem, OR, United States", 66.04),
    LEIPZIG_GERMANY("Leipzig, Germany", 66.04),
    DRESDEN_GERMANY("Dresden, Germany", 65.92),
    FORT_WAYNE_IN_UNITED_STATES("Fort Wayne, IN, United States", 65.88),
    DAYTON_OH_UNITED_STATES("Dayton, OH, United States", 65.84),
    SAN_JUAN_PUERTO_RICO("San Juan, Puerto Rico", 65.79),
    TAIPEI_TAIWAN("Taipei, Taiwan", 65.75),
    KANSAS_CITY_MO_UNITED_STATES("Kansas City, MO, United States", 65.74),
    LEICESTER_UNITED_KINGDOM("Leicester, United Kingdom", 65.59),
    OSHAWA_CANADA("Oshawa, Canada", 65.44),
    NANAIMO_BC_CANADA("Nanaimo, BC, Canada", 65.28),
    FORT_WORTH_TX_UNITED_STATES("Fort Worth, TX, United States", 65.19),
    PALMA_DE_MALLORCA_SPAIN("Palma de Mallorca, Spain", 65.17),
    MISSISSAUGA_CANADA("Mississauga, Canada", 65.08),
    QUEBEC_CITY_CANADA("Quebec City, Canada", 65.07),
    NORWICH_UNITED_KINGDOM("Norwich, United Kingdom", 64.95),
    BURNABY_CANADA("Burnaby, Canada", 64.94),
    FAYETTEVILLE_AR_UNITED_STATES("Fayetteville, AR, United States", 64.84),
    NAPLES_ITALY("Naples, Italy", 64.82),
    DERBY_UNITED_KINGDOM("Derby, United Kingdom", 64.7),
    MARSEILLE_FRANCE("Marseille, France", 64.64),
    KINGSTON_JAMAICA("Kingston, Jamaica", 64.59),
    HANOVER_GERMANY("Hanover, Germany", 64.57),
    RICHMOND_VA_UNITED_STATES("Richmond, VA, United States", 64.56),
    GOLD_COAST_AUSTRALIA("Gold Coast, Australia", 64.53),
    GREENSBORO_NC_UNITED_STATES("Greensboro, NC, United States", 64.46),
    BIRMINGHAM_UNITED_KINGDOM("Birmingham, United Kingdom", 64.46),
    WINDSOR_CANADA("Windsor, Canada", 64.42),
    DALLAS_TX_UNITED_STATES("Dallas, TX, United States", 64.32),
    ALBUQUERQUE_NM_UNITED_STATES("Albuquerque, NM, United States", 64.32),
    PHOENIX_AZ_UNITED_STATES("Phoenix, AZ, United States", 64.31),
    SOUTHAMPTON_UNITED_KINGDOM("Southampton, United Kingdom", 63.73),
    GAINESVILLE_FL_UNITED_STATES("Gainesville, FL, United States", 63.62),
    MONTREAL_CANADA("Montreal, Canada", 63.52),
    GRAND_RAPIDS_MI_UNITED_STATES("Grand Rapids, MI, United States", 63.47),
    TUCSON_AZ_UNITED_STATES("Tucson, AZ, United States", 63.35),
    MADISON_WI_UNITED_STATES("Madison, WI, United States", 63.3),
    CHATTANOOGA_TN_UNITED_STATES("Chattanooga, TN, United States", 63.28),
    FRESNO_CA_UNITED_STATES("Fresno, CA, United States", 63.25),
    WICHITA_KS_UNITED_STATES("Wichita, KS, United States", 63.18),
    WINNIPEG_CANADA("Winnipeg, Canada", 63.15),
    CAGLIARI_ITALY("Cagliari, Italy", 63.15),
    SALT_LAKE_CITY_UT_UNITED_STATES("Salt Lake City, UT, United States", 62.94),
    OTTAWA_CANADA("Ottawa, Canada", 62.88),
    DOHA_QATAR("Doha, Qatar", 62.81),
    DETROIT_MI_UNITED_STATES("Detroit, MI, United States", 62.77),
    NEWCASTLE_UPON_TYNE_UNITED_KINGDOM("Newcastle upon Tyne, United Kingdom", 62.76),
    TULSA_OK_UNITED_STATES("Tulsa, OK, United States", 62.67),
    CINCINNATI_OH_UNITED_STATES("Cincinnati, OH, United States", 62.65),
    SHEFFIELD_UNITED_KINGDOM("Sheffield, United Kingdom", 62.64),
    BELFAST_UNITED_KINGDOM("Belfast, United Kingdom", 62.42),
    LUBBOCK_TX_UNITED_STATES("Lubbock, TX, United States", 62.4),
    TAICHUNG_TAIWAN("Taichung, Taiwan", 62.23),
    DES_MOINES_IA_UNITED_STATES("Des Moines, IA, United States", 62.21),
    HOUSTON_TX_UNITED_STATES("Houston, TX, United States", 62.16),
    BARCELONA_SPAIN("Barcelona, Spain", 62.15),
    CARDIFF_UNITED_KINGDOM("Cardiff, United Kingdom", 62.12),
    LIVERPOOL_UNITED_KINGDOM("Liverpool, United Kingdom", 62),
    ABU_DHABI_UNITED_ARAB_EMIRATES("Abu Dhabi, United Arab Emirates", 61.94),
    OKLAHOMA_CITY_OK_UNITED_STATES("Oklahoma City, OK, United States", 61.72),
    PALERMO_ITALY("Palermo, Italy", 61.16),
    MONCTON_CANADA("Moncton, Canada", 61.15),
    NICOSIA_CYPRUS("Nicosia, Cyprus", 60.97),
    KNOXVILLE_TN_UNITED_STATES("Knoxville, TN, United States", 60.97),
    BEIRUT_LEBANON("Beirut, Lebanon", 60.79),
    HAMILTON_CANADA("Hamilton, Canada", 60.75),
    SPRINGFIELD_MO_UNITED_STATES("Springfield, MO, United States", 60.56),
    VANCOUVER_WA_UNITED_STATES("Vancouver, WA, United States", 60.46),
    ATHENS_GREECE("Athens, Greece", 60.44),
    TOLEDO_OH_UNITED_STATES("Toledo, OH, United States", 60.35),
    LITTLE_ROCK_AR_UNITED_STATES("Little Rock, AR, United States", 60.31),
    LOUISVILLE_KY_UNITED_STATES("Louisville, KY, United States", 60.24),
    MADRID_SPAIN("Madrid, Spain", 60.12),
    RENO_NV_UNITED_STATES("Reno, NV, United States", 59.84),
    HUNTSVILLE_AL_UNITED_STATES("Huntsville, AL, United States", 59.8),
    LEXINGTON_KY_UNITED_STATES("Lexington, KY, United States", 59.64),
    PORT_OF_SPAIN_TRINIDAD_AND_TOBAGO("Port of Spain, Trinidad And Tobago", 59.6),
    BOISE_ID_UNITED_STATES("Boise, ID, United States", 59.43),
    EL_PASO_TX_UNITED_STATES("El Paso, TX, United States", 59.37),
    SURREY_CANADA("Surrey, Canada", 59.18),
    LONDON_CANADA("London, Canada", 59.15),
    ABBOTSFORD_CANADA("Abbotsford, Canada", 58.95),
    KITCHENER_CANADA("Kitchener, Canada", 58.93),
    SAN_ANTONIO_TX_UNITED_STATES("San Antonio, TX, United States", 58.12),
    MONTEVIDEO_URUGUAY("Montevideo, Uruguay", 58.05),
    ZARAGOZA_SARAGOSSA_SPAIN("Zaragoza (Saragossa), Spain", 58),
    THESSALONIKI_GREECE("Thessaloniki, Greece", 57.97),
    SAN_JOSE_COSTA_RICA("San Jose, Costa Rica", 57.84),
    LIMASSOL_CYPRUS("Limassol, Cyprus", 57.71),
    ACCRA_GHANA("Accra, Ghana", 57.23),
    KAOHSIUNG_TAIWAN("Kaohsiung, Taiwan", 56.44),
    LJUBLJANA_SLOVENIA("Ljubljana, Slovenia", 56.34),
    VALENCIA_SPAIN("Valencia, Spain", 55.27),
    MANAMA_BAHRAIN("Manama, Bahrain", 55.23),
    TALLINN_ESTONIA("Tallinn, Estonia", 55.23),
    PANAMA_CITY_PANAMA("Panama City, Panama", 54.91),
    AMMAN_JORDAN("Amman, Jordan", 54.72),
    SEVILLE_SEVILLA_SPAIN("Seville (Sevilla), Spain", 54.7),
    LARNACA_CYPRUS("Larnaca, Cyprus", 54.31),
    LISBON_PORTUGAL("Lisbon, Portugal", 54.16),
    ALICANTE_SPAIN("Alicante, Spain", 53.9),
    SPLIT_CROATIA("Split, Croatia", 53.62),
    BANGKOK_THAILAND("Bangkok, Thailand", 53.61),
    SHARJAH_UNITED_ARAB_EMIRATES("Sharjah, United Arab Emirates", 53.45),
    DUBAI_UNITED_ARAB_EMIRATES("Dubai, United Arab Emirates", 53.32),
    RIJEKA_CROATIA("Rijeka, Croatia", 52.96),
    ZAGREB_CROATIA("Zagreb, Croatia", 52.2),
    MAKATI_PHILIPPINES("Makati, Philippines", 51.07),
    COIMBRA_PORTUGAL("Coimbra, Portugal", 51.07),
    MUSCAT_OMAN("Muscat, Oman", 51.04),
    AL_KHOBAR_SAUDI_ARABIA("Al Khobar, Saudi Arabia", 51.03),
    FUNCHAL_PORTUGAL("Funchal, Portugal", 50.9),
    RIGA_LATVIA("Riga, Latvia", 50.82),
    PORTO_PORTUGAL("Porto, Portugal", 50.43),
    SHANGHAI_CHINA("Shanghai, China", 50.41),
    GRANADA_SPAIN("Granada, Spain", 50.41),
    MALAGA_SPAIN("Malaga, Spain", 50.38),
    SANTIAGO_CHILE("Santiago, Chile", 50.37),
    JEDDAH_JIDDAH_SAUDI_ARABIA("Jeddah (Jiddah), Saudi Arabia", 49.99),
    ADDIS_ABABA_ETHIOPIA("Addis Ababa, Ethiopia", 49.96),
    TARTU_ESTONIA("Tartu, Estonia", 49.65),
    HAVANA_CUBA("Havana, Cuba", 49.52),
    QUITO_ECUADOR("Quito, Ecuador", 49.42),
    MARIBOR_SLOVENIA("Maribor, Slovenia", 49.3),
    SANTA_CRUZ_DE_TENERIFE_SPAIN("Santa Cruz de Tenerife, Spain", 48.69),
    RIYADH_SAUDI_ARABIA("Riyadh, Saudi Arabia", 48.68),
    BRATISLAVA_SLOVAKIA("Bratislava, Slovakia", 48.64),
    BRAGA_PORTUGAL("Braga, Portugal", 48.55),
    AD_DAMMAM_SAUDI_ARABIA("Ad Dammam, Saudi Arabia", 48.43),
    VILNIUS_LITHUANIA("Vilnius, Lithuania", 48.31),
    PRAGUE_CZECH_REPUBLIC("Prague, Czech Republic", 48.02),
    BANDAR_SERI_BEGAWAN_BRUNEI("Bandar Seri Begawan, Brunei", 48.01),
    HARARE_ZIMBABWE("Harare, Zimbabwe", 47.78),
    LAS_PALMAS_DE_GRAN_CANARIA_SPAIN("Las Palmas de Gran Canaria, Spain", 47.39),
    SAN_SALVADOR_EL_SALVADOR("San Salvador, El Salvador", 47.22),
    GUAYAQUIL_ECUADOR("Guayaquil, Ecuador", 47.21),
    BAGHDAD_IRAQ("Baghdad, Iraq", 47.17),
    PHUKET_THAILAND("Phuket, Thailand", 46.98),
    KLAIPEDA_LITHUANIA("Klaipeda, Lithuania", 46.98),
    KOSICE_SLOVAKIA("Kosice, Slovakia", 46.27),
    PRETORIA_SOUTH_AFRICA("Pretoria, South Africa", 45.89),
    SANTO_DOMINGO_DOMINICAN_REPUBLIC("Santo Domingo, Dominican Republic", 45.88),
    KAUNAS_LITHUANIA("Kaunas, Lithuania", 45.88),
    WINDHOEK_NAMIBIA("Windhoek, Namibia", 45.84),
    PHNOM_PENH_CAMBODIA("Phnom Penh, Cambodia", 45.67),
    JOHANNESBURG_SOUTH_AFRICA("Johannesburg, South Africa", 45.51),
    OSIJEK_CROATIA("Osijek, Croatia", 44.95),
    BRNO_CZECH_REPUBLIC("Brno, Czech Republic", 44.59),
    MOSCOW_RUSSIA("Moscow, Russia", 44.54),
    SELANGOR_MALAYSIA("Selangor, Malaysia", 44.53),
    CAMPINAS_BRAZIL("Campinas, Brazil", 44.45),
    GUATEMALA_CITY_GUATEMALA("Guatemala City, Guatemala", 44.39),
    DAR_ES_SALAAM_TANZANIA("Dar es Salaam, Tanzania", 44.33),
    PETALING_JAYA_MALAYSIA("Petaling Jaya, Malaysia", 44.31),
    SAO_PAULO_BRAZIL("Sao Paulo, Brazil", 44.16),
    RIO_DE_JANEIRO_BRAZIL("Rio de Janeiro, Brazil", 44.12),
    BRASILIA_BRAZIL("Brasilia, Brazil", 44.02),
    PENANG_MALAYSIA("Penang, Malaysia", 43.98),
    BEIJING_CHINA("Beijing, China", 43.88),
    BUDAPEST_HUNGARY("Budapest, Hungary", 43.74),
    GDANSK_POLAND("Gdansk, Poland", 42.82),
    JOHOR_BAHRU_MALAYSIA("Johor Bahru, Malaysia", 42.59),
    PATTAYA_THAILAND("Pattaya, Thailand", 42.53),
    IRBIL_IRAQ("Irbil, Iraq", 42.51),
    KUALA_LUMPUR_MALAYSIA("Kuala Lumpur, Malaysia", 42.44),
    WARSAW_POLAND("Warsaw, Poland", 42.32),
    SHENZHEN_CHINA("Shenzhen, China", 42.21),
    KUCHING_MALAYSIA("Kuching, Malaysia", 42.15),
    KOTA_KINABALU_MALAYSIA("Kota Kinabalu, Malaysia", 42.15),
    PETERBOROUGH_UNITED_KINGDOM("Peterborough, United Kingdom", 41.93),
    NAIROBI_KENYA("Nairobi, Kenya", 41.76),
    JAKARTA_INDONESIA("Jakarta, Indonesia", 41.6),
    CAPE_TOWN_SOUTH_AFRICA("Cape Town, South Africa", 41.58),
    BALI_INDONESIA("Bali, Indonesia", 41.48),
    LIMA_PERU("Lima, Peru", 41.47),
    OLOMOUC_CZECH_REPUBLIC("Olomouc, Czech Republic", 41.27),
    GDYNIA_POLAND("Gdynia, Poland", 41.22),
    RECIFE_BRAZIL("Recife, Brazil", 40.67),
    PORTO_ALEGRE_BRAZIL("Porto Alegre, Brazil", 40.56),
    OSTRAVA_CZECH_REPUBLIC("Ostrava, Czech Republic", 40.55),
    CHIANG_MAI_THAILAND("Chiang Mai, Thailand", 40.53),
    BELO_HORIZONTE_BRAZIL("Belo Horizonte, Brazil", 40.48),
    DURBAN_SOUTH_AFRICA("Durban, South Africa", 40.48),
    BUCHAREST_ROMANIA("Bucharest, Romania", 40.39),
    SOFIA_BULGARIA("Sofia, Bulgaria", 40.36),
    GUANGZHOU_CHINA("Guangzhou, China", 40.29),
    FLORIANOPOLIS_BRAZIL("Florianopolis, Brazil", 40.26),
    BELGRADE_SERBIA("Belgrade, Serbia", 40.1),
    WROCLAW_POLAND("Wroclaw, Poland", 40),
    PODGORICA_MONTENEGRO("Podgorica, Montenegro", 39.83),
    KRAKOW_CRACOW_POLAND("Krakow (Cracow), Poland", 39.53),
    PORT_ELIZABETH_SOUTH_AFRICA("Port Elizabeth, South Africa", 39.41),
    SAINT_PETERSBURG_RUSSIA("Saint Petersburg, Russia", 39.25),
    SARAJEVO_BOSNIA_AND_HERZEGOVINA("Sarajevo, Bosnia And Herzegovina", 39.25),
    VARNA_BULGARIA("Varna, Bulgaria", 39.13),
    POZNAN_POLAND("Poznan, Poland", 38.99),
    CONSTANTA_ROMANIA("Constanta, Romania", 38.89),
    RABAT_MOROCCO("Rabat, Morocco", 38.59),
    BUENOS_AIRES_ARGENTINA("Buenos Aires, Argentina", 38.57),
    BYDGOSZCZ_POLAND("Bydgoszcz, Poland", 38.54),
    SZEGED_HUNGARY("Szeged, Hungary", 38.41),
    HANOI_VIETNAM("Hanoi, Vietnam", 38.34),
    CURITIBA_BRAZIL("Curitiba, Brazil", 38.34),
    TIMISOARA_ROMANIA("Timisoara, Romania", 38.19),
    CLUJ_NAPOCA_ROMANIA("Cluj-Napoca, Romania", 38.13),
    DEBRECEN_HUNGARY("Debrecen, Hungary", 38.05),
    SUZHOU_CHINA("Suzhou, China", 37.95),
    MANILA_PHILIPPINES("Manila, Philippines", 37.95),
    ISTANBUL_TURKEY("Istanbul, Turkey", 37.85),
    HO_CHI_MINH_CITY_VIETNAM("Ho Chi Minh City, Vietnam", 37.82),
    KATOWICE_POLAND("Katowice, Poland", 37.48),
    SZCZECIN_POLAND("Szczecin, Poland", 37.35),
    CHELYABINSK_RUSSIA("Chelyabinsk, Russia", 37.29),
    TIRANA_ALBANIA("Tirana, Albania", 37.25),
    LODZ_POLAND("Lodz, Poland", 37.13),
    BRASOV_ROMANIA("Brasov, Romania", 37.13),
    BANJA_LUKA_BOSNIA_AND_HERZEGOVINA("Banja Luka, Bosnia And Herzegovina", 36.54),
    IASI_ROMANIA("Iasi, Romania", 36.54),
    PLOVDIV_BULGARIA("Plovdiv, Bulgaria", 36.45),
    CEBU_PHILIPPINES("Cebu, Philippines", 36.41),
    YEKATERINBURG_RUSSIA("Yekaterinburg, Russia", 36.41),
    BURGAS_BULGARIA("Burgas, Bulgaria", 36.26),
    CHENGDU_CHINA("Chengdu, China", 36.16),
    CUENCA_ECUADOR("Cuenca, Ecuador", 36.13),
    LUBLIN_POLAND("Lublin, Poland", 36.12),
    COLOMBO_SRI_LANKA("Colombo, Sri Lanka", 36),
    SAMARA_RUSSIA("Samara, Russia", 35.96),
    ARAD_ROMANIA("Arad, Romania", 35.84),
    SURABAYA_INDONESIA("Surabaya, Indonesia", 35.72),
    CASABLANCA_MOROCCO("Casablanca, Morocco", 35.68),
    SIBIU_ROMANIA("Sibiu, Romania", 35.63),
    BANDUNG_INDONESIA("Bandung, Indonesia", 35.58),
    PARAMARIBO_SURINAME("Paramaribo, Suriname", 35.45),
    KALININGRAD_RUSSIA("Kaliningrad, Russia", 35.4),
    NOVI_SAD_SERBIA("Novi Sad, Serbia", 35.36),
    BOGOTA_COLOMBIA("Bogota, Colombia", 35.05),
    YOGYAKARTA_INDONESIA("Yogyakarta, Indonesia", 34.91),
    ASTANA_KAZAKHSTAN("Astana, Kazakhstan", 34.9),
    ANKARA_TURKEY("Ankara, Turkey", 34.77),
    SKOPJE_MACEDONIA("Skopje, Macedonia", 34.68),
    ORADEA_ROMANIA("Oradea, Romania", 34.35),
    NIS_SERBIA("Nis, Serbia", 34.2),
    TEHRAN_IRAN("Tehran, Iran", 34.19),
    MEXICO_CITY_MEXICO("Mexico City, Mexico", 34.18),
    ULAANBAATAR_MONGOLIA("Ulaanbaatar, Mongolia", 34.16),
    MONTERREY_MEXICO("Monterrey, Mexico", 34.12),
    MINSK_BELARUS("Minsk, Belarus", 34.07),
    NIZHNY_NOVGOROD_RUSSIA("Nizhny Novgorod, Russia", 34.04),
    BARRANQUILLA_COLOMBIA("Barranquilla, Colombia", 34.04),
    IZMIR_TURKEY("Izmir, Turkey", 34.03),
    MEDELLIN_COLOMBIA("Medellin, Colombia", 33.82),
    ANTALYA_TURKEY("Antalya, Turkey", 33.78),
    CHISINAU_MOLDOVA("Chisinau, Moldova", 33.75),
    BURSA_TURKEY("Bursa, Turkey", 33.72),
    KAZAN_RUSSIA("Kazan, Russia", 33.67),
    NOVOSIBIRSK_RUSSIA("Novosibirsk, Russia", 33.65),
    DAVAO_PHILIPPINES("Davao, Philippines", 33.57),
    ASUNCION_PARAGUAY("Asuncion, Paraguay", 33.49),
    ALGIERS_ALGERIA("Algiers, Algeria", 33.44),
    LAGOS_NIGERIA("Lagos, Nigeria", 33.33),
    DUMAGUETE_PHILIPPINES("Dumaguete, Philippines", 33.21),
    YEREVAN_ARMENIA("Yerevan, Armenia", 33.16),
    TIJUANA_MEXICO("Tijuana, Mexico", 32.7),
    ALMATY_KAZAKHSTAN("Almaty, Kazakhstan", 32.51),
    ROSTOV_NA_DONU_RUSSIA("Rostov-na-donu, Russia", 32.4),
    KRASNODAR_RUSSIA("Krasnodar, Russia", 32.37),
    KATHMANDU_NEPAL("Kathmandu, Nepal", 31.89),
    CRAIOVA_ROMANIA("Craiova, Romania", 31.78),
    VORONEZH_RUSSIA("Voronezh, Russia", 31.74),
    QUEZON_CITY_PHILIPPINES("Quezon City, Philippines", 31.66),
    DHAKA_BANGLADESH("Dhaka, Bangladesh", 31.57),
    KAMPALA_UGANDA("Kampala, Uganda", 31.51),
    GUADALAJARA_MEXICO("Guadalajara, Mexico", 31.46),
    CANCUN_MEXICO("Cancun, Mexico", 31.35),
    QUERETARO_MEXICO("Queretaro, Mexico", 31.01),
    GURGAON_INDIA("Gurgaon, India", 30.71),
    CALI_COLOMBIA("Cali, Colombia", 30.48),
    TBILISI_GEORGIA("Tbilisi, Georgia", 30.22),
    ODESSA_UKRAINE("Odessa, Ukraine", 30.13),
    TASHKENT_UZBEKISTAN("Tashkent, Uzbekistan", 29.94),
    PUERTO_VALLARTA_MEXICO("Puerto Vallarta, Mexico", 29.82),
    KIEV_UKRAINE("Kiev, Ukraine", 29.42),
    BAKU_AZERBAIJAN("Baku, Azerbaijan", 29.41),
    MERIDA_MEXICO("Merida, Mexico", 29.39),
    MUMBAI_INDIA("Mumbai, India", 29.03),
    PUEBLA_MEXICO("Puebla, Mexico", 28.89),
    DELHI_INDIA("Delhi, India", 28.67),
    NOIDA_INDIA("Noida, India", 28.55),
    DNIPRO_UKRAINE("Dnipro, Ukraine", 27.96),
    CARACAS_VENEZUELA("Caracas, Venezuela", 27.82),
    PUNE_INDIA("Pune, India", 27.41),
    LVIV_UKRAINE("Lviv, Ukraine", 27.24),
    LUDHIANA_INDIA("Ludhiana, India", 27.17),
    BANGALORE_INDIA("Bangalore, India", 26.83),
    KHARKIV_UKRAINE("Kharkiv, Ukraine", 26.71),
    TUNIS_TUNISIA("Tunis, Tunisia", 26.53),
    PRISTINA_KOSOVO("Pristina, Kosovo (Disputed Territory)", 26.24),
    CHANDIGARH_INDIA("Chandigarh, India", 26),
    ISLAMABAD_PAKISTAN("Islamabad, Pakistan", 25.86),
    LAHORE_PAKISTAN("Lahore, Pakistan", 25.83),
    CAIRO_EGYPT("Cairo, Egypt", 25.68),
    JAIPUR_INDIA("Jaipur, India", 25.46),
    INDORE_INDIA("Indore, India", 25.4),
    THANE_INDIA("Thane, India", 25.31),
    CHENNAI_INDIA("Chennai, India", 25.2),
    KOLKATA_INDIA("Kolkata, India", 24.8),
    LUCKNOW_LAKHNAU_INDIA("Lucknow (Lakhnau), India", 24.75),
    GOA_INDIA("Goa, India", 24.34),
    AHMEDABAD_INDIA("Ahmedabad, India", 24.24),
    ALEXANDRIA_EGYPT("Alexandria, Egypt", 23.92),
    KARACHI_PAKISTAN("Karachi, Pakistan", 23.9),
    SUMY_UKRAINE("Sumy, Ukraine", 23.84),
    SURAT_INDIA("Surat, India", 23.77),
    HYDERABAD_INDIA("Hyderabad, India", 23.59),
    NAGPUR_INDIA("Nagpur, India", 22.76),
    GUWAHATI_INDIA("Guwahati, India", 22.68),
    MYSORE_INDIA("Mysore, India", 22.41),
    BHUBANESWAR_INDIA("Bhubaneswar, India", 22.4),
    MANGALORE_INDIA("Mangalore, India", 22.4),
    COIMBATORE_INDIA("Coimbatore, India", 22.38),
    BHOPAL_INDIA("Bhopal, India", 22.37),
    VADODARA_INDIA("Vadodara, India", 22.28),
    KOCHI_INDIA("Kochi, India", 21.73),
    VISAKHAPATNAM_INDIA("Visakhapatnam, India", 21.52),
    NAVI_MUMBAI_INDIA("Navi Mumbai, India", 19.3),
    THIRUVANANTHAPURAM_INDIA("Thiruvananthapuram, India", 19.26);

    private final String name;
    private final double costOfLiving;

    Location(String name, double costOfLiving) {
      this.name = name;
      this.costOfLiving = costOfLiving;
    }

    public String getName() {
      return name;
    }

    public double getCostOfLiving() {
      return costOfLiving;
    }

    @Override
    public String toString() {
      return getName();
    }
  }
}
