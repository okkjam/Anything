import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends jdbcDAO {
	private static ProductDAO _dao;
	
	private ProductDAO() {
		
	}
	
	static {
		_dao = new ProductDAO();
	}
	
	public static ProductDAO getDAO() {
		return _dao;
	}
	
	
	public int insertProduct(ProductDTO product) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int rows=0;
		try {
			con=getConnection();
			
			String sql = "insert into product values(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getNo());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getPrice());
			pstmt.setString(4, product.getAmount());
			pstmt.setString(5, product.getTemp());
			pstmt.setString(6, product.getIndate());
			pstmt.setString(7, product.getNote());
			
			rows = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("insert오류");
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	

	public int updateProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			
			String sql = "update product set price=?, amount=?, indate=?, note=? where name=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, product.getPrice());
			pstmt.setString(2, product.getAmount());
			pstmt.setString(3, product.getIndate());
			pstmt.setString(4, product.getNote());
			pstmt.setString(5, product.getName());
			
			rows=pstmt.executeUpdate();
			
		} catch(SQLException e) {
			System.out.println("update오류");
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	

	public int deleteProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		
		try {
			con=getConnection();
			
			String sql="delete from product where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getName());
			
			rows=pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("delete오류");
		} finally {
			close(con,pstmt);
		}
		return rows;
	}
	

	public ProductDTO selectNameProduct(String name) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductDTO product=null;
		
		try {
			con = getConnection();
			
			String sql="select * from product where name= ? order by no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				product = new ProductDTO();
				
				product.setNo(rs.getString("no"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setAmount(rs.getString("amount"));
				product.setTemp(rs.getString("temp"));
				product.setIndate(rs.getString("indate"));
				product.setNote(rs.getString("note"));
			}
		} catch(SQLException e) {
			System.out.println("select오류");
		} finally {
			close(con,pstmt, rs);
		}
		return product;
	}
	
	

	public List<ProductDTO> allProduct() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductDTO> productList = new ArrayList<ProductDTO>();
		
		try {
			con = getConnection();
			
			String sql="select * from product order by no";
			pstmt = con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product = new ProductDTO();
				product.setNo(rs.getString("no"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getString("price"));
				product.setAmount(rs.getString("amount"));
				product.setTemp(rs.getString("temp"));
				product.setIndate(rs.getString("indate"));
				product.setNote(rs.getString("note"));
				
				productList.add(product);
			}
		} catch(SQLException e) {
			System.out.println("selectAll오류");
		} finally {
			close(con,pstmt,rs);
		}
		return productList;
	}
}
