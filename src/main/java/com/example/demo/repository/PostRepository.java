package com.example.demo.repository;

import com.example.demo.domain.Post;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository {
    private final DataSource dataSource;

    public PostRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Post> findAll() {
        String sql = "select * from 물품_게시글";
        List<Post> posts = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Post post = new Post();
                post.setPostNumber(rs.getLong("게시글번호"));
                post.setStuId(rs.getLong("학번"));
                post.setDepartmentName(rs.getString("학과명"));
                post.setCategory(rs.getString("카테고리명"));
                post.setTrader(rs.getLong("거래자"));
                post.setPrice(rs.getLong("거래금액"));
                post.setItemName(rs.getString("물품명"));
                post.setItemDescription(rs.getString("물품설명"));
                post.setTradingStatus(rs.getString("거래여부"));
                post.setRegistrationDate(rs.getDate("등록날짜"));
                posts.add(post);
            }
        } catch (Exception e) {
            throw new RuntimeException("검색 실패", e);
        }

        return posts;
    }

    public List<Post> findByKeyword(String keyword) {
        String sql = "select 게시글번호, 학번, 학과명, 카테고리명, 거래자, 거래금액, " +
                "물품명, 물품설명, 거래여부, 등록날짜 " +
                "from 게시글 where 물품명 like ? or 물품설명 like ? or 카테고리명 like ?";
        List<Post> posts = new ArrayList<>();

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            pstmt.setString(3, "%" + keyword + "%");

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Post post = new Post();
                    post.setPostNumber(rs.getLong("게시글번호"));
                    post.setStuId(rs.getLong("학번"));
                    post.setDepartmentName(rs.getString("학과명"));
                    post.setCategory(rs.getString("카테고리명"));
                    post.setTrader(rs.getLong("거래자"));
                    post.setPrice(rs.getLong("거래금액"));
                    post.setItemName(rs.getString("물품명"));
                    post.setItemDescription(rs.getString("물품설명"));
                    post.setTradingStatus(rs.getString("거래여부"));
                    post.setRegistrationDate(rs.getDate("등록날짜"));
                    posts.add(post);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("게시글 검색 실패", e);
        }

        return posts;
    }

    public void save(Post post) {
        String sql = "insert into 게시글 (학번, 학과명, 카테고리명, 거래자, 거래금액, " +
                "물품명, 물품설명, 거래여부, 등록날짜) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, post.getStuId());
            pstmt.setString(2, post.getDepartmentName());
            pstmt.setString(3, post.getCategory());
            pstmt.setLong(4, post.getTrader());
            pstmt.setLong(5, post.getPrice());
            pstmt.setString(6, post.getItemName());
            pstmt.setString(7, post.getItemDescription());
            pstmt.setString(8, post.getTradingStatus());
            pstmt.setDate(9, new java.sql.Date(post.getRegistrationDate().getTime()));

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("게시글 등록 실패", e);
        }
    }

    public void update(Post post) {
        String sql = "update 게시글 set 학번=?, 학과명=?, 카테고리명=?, 거래자=?, " +
                "거래금액=?, 물품명=?, 물품설명=?, 거래여부=? where 게시글번호=?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, post.getStuId());
            pstmt.setString(2, post.getDepartmentName());
            pstmt.setString(3, post.getCategory());
            pstmt.setLong(4, post.getTrader());
            pstmt.setLong(5, post.getPrice());
            pstmt.setString(6, post.getItemName());
            pstmt.setString(7, post.getItemDescription());
            pstmt.setString(8, post.getTradingStatus());
            pstmt.setLong(9, post.getPostNumber());

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("게시글 수정 실패", e);
        }
    }

    public Optional<Post> findById(Long postNumber) {
        String sql = "select 게시글번호, 학번, 학과명, 카테고리명, 거래자, 거래금액, " +
                "물품명, 물품설명, 거래여부, 등록날짜 from 게시글 where 게시글번호 = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, postNumber);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Post post = new Post();
                    post.setPostNumber(rs.getLong("게시글번호"));
                    post.setStuId(rs.getLong("학번"));
                    post.setDepartmentName(rs.getString("학과명"));
                    post.setCategory(rs.getString("카테고리명"));
                    post.setTrader(rs.getLong("거래자"));
                    post.setPrice(rs.getLong("거래금액"));
                    post.setItemName(rs.getString("물품명"));
                    post.setItemDescription(rs.getString("물품설명"));
                    post.setTradingStatus(rs.getString("거래여부"));
                    post.setRegistrationDate(rs.getDate("등록날짜"));
                    return Optional.of(post);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("게시글번호로 검색불가", e);
        }
        return null;
    }

    public void delete(Long postNumber) {
        String sql = "delete from 게시글 where 게시글번호 = ?";

        try (Connection conn = dataSource.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, postNumber);
            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("삭제 실패", e);
        }
    }
}