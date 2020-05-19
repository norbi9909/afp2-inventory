import React, {Component} from 'react';
import {Card, Table} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faList} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';

export default class ProductList extends Component{

    constructor(props){
        super(props);
        this.state = {
            list: []
        };
    }

    componentDidMount(){
        axios.get("http://localhost:8081/product/list")
            .then(response => response.data)
            .then((data) => {
                this.setState({list: data});
            });
    }

    render(){
        return(
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header><FontAwesomeIcon icon={faList} /> Product List</Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant ="dark">
                        <thead>
                            <tr>
                            <th>Product ID</th>
                            <th>Product Name</th>
                            <th>Product Description</th>
                            <th>Product Count</th>
                            <th>Product Price</th>
                            <th>Available</th>
                            <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.list.length === 0?
                                <tr align="center">
                                    <td colSpan="7">Products Available.</td>
                                </tr> :
                                this.state.list.map((product) => (
                                <tr key={product.productID}>
                                    <td>{product.productID}</td>
                                    <td>{product.product_Name}</td>
                                    <td>{product.product_Description}</td>
                                    <td>{product.product_Count}</td>
                                    <td>{product.product_Price}</td>
                                    <td>{product.product__is_Available}</td>
                                    <td></td>
                                </tr>
                                ))
                            }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}