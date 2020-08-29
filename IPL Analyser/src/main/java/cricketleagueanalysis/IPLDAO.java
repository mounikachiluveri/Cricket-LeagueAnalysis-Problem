package cricketleagueanalysis;


    public class IPLDAO {
        public int position;
        public String player;
        public int matches;
        public int runs;
        public int sixes;
        public double batsManAverage;
        public double bowlingAverage;
        public double strikeRate;
        public int fours;
        public double economy;
        public int fourWkt;
        public int fiveWicket;
        public int wickets;

        public IPLDAO(MostRunsData iplRunsCsv) {
            position = iplRunsCsv.position;
            player = iplRunsCsv.player;
            matches = iplRunsCsv.matches;
            runs = iplRunsCsv.runs;
            strikeRate = iplRunsCsv.strikeRate;
            sixes = iplRunsCsv.sixes;
            batsManAverage = iplRunsCsv.average;
            fours = iplRunsCsv.fours;
        }

        public IPLDAO(MostWicketsData iplWicketCsv) {
            position = iplWicketCsv.position;
            player = iplWicketCsv.player;
            matches = iplWicketCsv.matches;
            runs = iplWicketCsv.runs;
            strikeRate = iplWicketCsv.strikeRate;
            bowlingAverage = iplWicketCsv.average;
            economy = iplWicketCsv.economy;
            fiveWicket = iplWicketCsv.fiveWicket;
            fiveWicket = iplWicketCsv.fiveWicket;
            wickets = iplWicketCsv.wickets;
        }

        public IPLDAO() {
        }

        public Object getCricketDTO(IPLAnalyser.PlayerType playerType) {
            if (playerType.equals(IPLAnalyser.PlayerType.BATSMAN))
                return new MostRunsData(position, player, matches, runs, strikeRate, sixes, batsManAverage, fours);
            return new MostWicketsData(position, player, runs, bowlingAverage, matches, strikeRate, economy, fourWkt, fiveWicket, wickets);
        }
    }


