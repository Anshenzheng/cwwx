import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
// 将一个字符串按照zip方式压缩和解压缩   
public class ZipUtil2 {

    // 压缩
    public static String compress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toString("ISO-8859-1");
    }

    // 解压缩
    public static String uncompress(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(str
                .getBytes("ISO-8859-1"));
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer))>= 0) {
            out.write(buffer, 0, n);
        }
        // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
        return out.toString();
    }

    // 测试方法
    public static void main(String[] args) throws IOException {

        //测试字符串
        String str="tJPfoC-KfCP3fP36q6--jtLOMqOybD62aKDsLR42-hcqEIL45Ic2MfQWjPJHJbTPBarE2pTy-Db1HxbSj4Qz2-KY5UuOJ4rNLKn2Bh7H5l5nhMJeb67JDMP0-xKH0-6y523ion5vQpnOMxtujj_bjjcLjaRf-b-XKK-X3b7Efbj6V-O_bf--DRD3MtnOt5bxQT6Q-l74MqRJOn7pQJjxy5K_hUn9Qj5ltT5datbpafokfPJHQT3m5hQbbN3i-Cr8tDbZWb3cWKJq8UbSMTjme6j0jNKtJjKHfKc2sJc2an5BDP5nM-Q_bP_Hqxby26njbe7eaJ5nJDohM-cLX5tbjh_BKbo9QJTr52keQ4JJQpP-HJ7FbJ6-KR88MmFL0RcBJTnHKl0MLnclbb0xynoD5xL73MnMBMPj5mOnankKLIFKhKIlD5DMj5Pb-eTL545-aDvfW-08Kbu3Sf_mKU6qLT5XeJojJtrIJbnIbPnGBMo08b3o5p64-l0njxQybjbpJnRrQM3H-RKb_pjJ-UonDh8v2a7MJUntKjnLMhoO5hvvhb5O3M7OjlOhjN_8JT0HJb3fL-08MnQBfJuk-PI3Mb8TKP6-35KH-jvn-R6OJKbtqp6aXp50X-byXMRWQq37JD6yKfOE-bO4SPbYhhorMKuze-oxJpOD5JbMopvaHRPB_IbvbURvD-Lg3-7Wtq8EtJItoKDhfIP3Jt5k2-r_q6oBDgT22-us-ItOQhcH0KLKoxQz2xbojT0EQtQPWhjEBNRNBbIaafb1MRjv24RfQUFiyPvyafb4KH5RBp5TtUJ8eCnTDMRN-6_ie-5yKMnitIT9-pnoJft0hCKmjj_MjToM5pJfetry-DTJBROo54b5KROvhjROLUtyyxomtjjLK2jxQbA5JPDhjU5O0R6dMnFLMlJILUkqKm58Qh77Bj66fCnLKJr0MMkJQttjQPTOfIkjahjttlc-sb7TyU42bf47yM4qQTT2-DA__IIMJCoP";

        System.out.println("原长度："+str.length());

        System.out.println("压缩后："+ZipUtil2.compress(str).length());

        System.out.println("解压缩："+ZipUtil2.uncompress(ZipUtil2.compress(str)));
    }

}  
