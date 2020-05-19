import React, {Component} from 'react';
import {Card, Table} from 'react-bootstrap';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import {faList} from '@fortawesome/free-solid-svg-icons'
import axios from 'axios';

export default class ProductList extends Component{

    constructor(props){
        super(props);
        this.state = {
            products: []
        };
    }

    componentDidMount(){
        axios.get("https://localhost:8081/product/list")
            .then(response => console.log(response.data));
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
                            <tr align="center">
                                <td colSpan="7">No Products Available.</td>
                            </tr>
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}