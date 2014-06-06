import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: s.sankaranarayanan
 * Date: 12/9/13
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringConverter {
    private static final String SELECT_FIELDS_SQL =
            "SELECT "
                    + "ip.swInstProdId, ip.swMasterInstProdId,ip.swParentInstProdId, ip.swAssetTag,"
                    + "ip.swStatus, ip.swSiteId, ip.brPortSpeed,pr.swName as prodReleaseName,ip.svAip,"
                    + "ip.swDateCreated,ip.swCreatedBy,ip.brDateModified,ip.brPhysicalSiteId,"
                    + "ip.brModifiedBy,ip.timestamp,pr.swProdReleaseId,pr.swVersion,"
                    + "i.brInterfaceType,i.brIpaddr,i.brPrimaryIp,i.brClassB,i.brClassC,i.brClassD,"
                    + "i.brInterfaceId, ip.swSerialNumber, ip.swnote, "
                    + "n.swName as NetworkIpAddr,n.brDIpRangeBegin,n.brDIpRangeEnd,"
                    + "n.brNetworkId, n.brSubnetMask as NetworkSubnetMask,"
                    + "pl.swProductLineId, pl.swName as productLineName";

    private static final String FROM_JOIN_SQL =
            " FROM SW_INST_PRODUCT ip (NOLOCK)"
                    + " LEFT JOIN SW_PROD_RELEASE pr (NOLOCK) ON ip.swProdReleaseId=pr.swProdReleaseId"
                    + " LEFT JOIN BR_INTERFACE i (NOLOCK,INDEX=briBR_INTERFACE07) ON "
                    +       "ip.swInstProdId=i.swInstProdId AND "
                    +       "i.brPrimaryIP=1 AND i.brInterfaceType like 'IP Address%'"
                    + " LEFT JOIN BR_NETWORK n (NOLOCK) ON i.brNetworkId=n.brNetworkId"
                    + " LEFT JOIN SW_PRODUCT_LINE AS pl (NOLOCK) ON pr.swProductLineId=pl.swProductLineId";


    private static final String SELECT_FROM_SQL =
            "SELECT"
//            + " brAccountRequestId,swStatus,brAccountId,brAcctInstProdId,svDataCenterSiteId,"
                    // TODO - this is a temporary fake - we are using brContractNum instead of svDataCenterSiteId
                    // because the field is not currently in the database
                    + " ar.brAccountRequestId,ar.swStatus,ar.brAccountId,ar.brAcctInstProdId,"
                    + " ar.brConnectivityWPId,ar.brParentAccountRequestId,ar.swType,"
                    + " ar.swDateCreated,ar.swCreatedBy,ar.brDateModified,ar.brModifiedBy,"
                    + " ar.swMasterInstProdId, ar.brAcctInstProdId, "
                    + " ar.brSalesPackageId, ar.swProdReleaseId, ar.swDateInstalled, ar.brCustomerWantDate, "
                    + "pr.swName as ServicePkgProductName, pr_addon.swName as AddOnProductName"
                    + " FROM BR_ACCOUNT_REQUEST ar (NOLOCK)"
                    + " LEFT JOIN SW_PROD_RELEASE pr (NOLOCK) on ar.brSalesPackageId = pr.swProdReleaseId"
                    + " LEFT JOIN SW_PROD_RELEASE pr_addon  (NOLOCK) on ar.swProdReleaseId = pr_addon.swProdReleaseId";

    public static void main(String[] args) {
        /*System.out.println(StringConverter.SELECT_FIELDS_SQL);
        System.out.println(FROM_JOIN_SQL);
        StringBuffer sqlBuf = new StringBuffer( SELECT_FIELDS_SQL );
        sqlBuf.append( ", ar.brAccountRequestId " );
        sqlBuf.append( FROM_JOIN_SQL );
        sqlBuf.append( " JOIN BR_ACCT_INST_PRODUCT aip (NOLOCK) on ip.svAIP = aip.brAcctInstProdId " );
        sqlBuf.append( " JOIN BR_ACCOUNT_REQUEST ar (NOLOCK) on aip.brAcctInstProdId = ar.brAcctInstProdId ");
        sqlBuf.append( " where ar.brAccountRequestId = ? " );
        sqlBuf.append( " and pl.swName = ? ");
        sqlBuf.append( " and ip.swStatus != 'Scrap' ");
        sqlBuf.append( " order by ip.swInstProdId desc ");
        System.out.println(sqlBuf.toString());

        System.out.println(SELECT_FROM_SQL);*/
        System.out.println(isAlphaNumeric("S258511CH3VH03-L01"));
        StringConverter sc = new StringConverter();
        System.out.println("Calling doQuery..............");
        long now = System.currentTimeMillis();
        sc.doQuery();
        System.out.println("Time " + (System.currentTimeMillis() - now));


    }

    /**
     * Determines whether the given string has all alpha numeric characters.
     * @param source the string to analyze
     * @return true if all of the characters in source are alpha numeric
     */
    public static boolean isAlphaNumeric( String source )
    {
        boolean foundNonAlphaNumeric = false;

        if ( source != null )
        {
            for ( int i = 0; i < source.length(); i++ )
            {
                if ( !Character.isLetterOrDigit( source.charAt( i ) ) )
                {
                    foundNonAlphaNumeric = true;
                    break;
                }
            }
        }

        return !foundNonAlphaNumeric;
    }


    private static String url = "jdbc:oracle:thin:@sl7-ossoraclestg01.savvis.lab:1521:objhistory";
    private static String className = "oracle.jdbc.driver.OracleDriver";
    private static String user = "histadmin";
    private static String pwd = "histadmin";

   /* private static String url = "jdbc:oracle:thin:@10.12.167.58:1521:objhistory";
    private static String className = "oracle.jdbc.driver.OracleDriver";
    private static String user = "EventNotifier";
    private static String pwd = "3vent!";*/
    
    private static String SQL = "\n" +
            "select serverserial, lastoccurrence, firstoccurrence, automationtag, tally from histadmin.alerts_status \n" +
            "where 1=1\n" +
            "and lastoccurrence > TO_DATE('2013-12-05 16:00:00', 'YYYY-MM-DD HH24:MI:SS')  \n" +
            "and lastoccurrence < TO_DATE('2013-12-05 18:59:59', 'YYYY-MM-DD HH24:MI:SS') \n" +
            "and cmdbidentifier=27503262\n";

    
    public void doQuery() {
        Connection con = null;
        Statement st = null;
        ResultSet r = null;
        try {
            con = getCon();
            System.out.println("Got conn.... " + con);
            st = con.createStatement();
            r = st.executeQuery(SQL);
            int count = 0;
            System.out.println("Got r ... "  + r);
            while (r.next()) {
                String lastoccurrence = r.getString("lastoccurrence");
                String firstoccurrence = r.getString("firstoccurrence");
                String at = r.getString("automationtag");
                String tally = r.getString("tally");
                String serverserial = r.getString("serverserial");
                System.out.println("serverserial " +serverserial +" lastoccurence " + lastoccurrence + " first " + firstoccurrence + " automationtag " + at + " tally " + tally);
            }
            System.out.println("THe count is " + count);
            
        } catch (Exception jE) {
            jE.printStackTrace();
            
        } finally {
            try{
                if(r != null) {
                    r.close();
                }
                if(st != null) {
                    st.close();
                }
                if(con != null) {
                    con.close();
                }
            } catch (Exception jE) {
                jE.printStackTrace();
            }
        }
        
    }
    
    public Connection getCon(){
        Connection con = null;
        try {
            Class.forName(className);
            con  =DriverManager.getConnection(url, user, pwd);

            
        }   catch(Exception jE) {
            jE.printStackTrace();
        }
        return  con;
    }
    
    

}
